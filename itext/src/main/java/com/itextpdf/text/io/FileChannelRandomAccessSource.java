package com.itextpdf.text.io;

import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * A RandomAccessSource that is based on an underlying {@link FileChannel}.  The channel will be mapped into memory for efficient reads.
 * @since 5.3.5
 */
class FileChannelRandomAccessSource implements RandomAccessSource {
    private static final int DEFAULT_BUFSIZE = 1 << 28; 

    /**
     * The size of the buffers to use when mapping files into memory.  This must be greater than 0 and less than {@link Integer#MAX_VALUE}
     */
    private final int bufferSize;
    
    /**
     * The channel this source is based on
     */
    private final FileChannel channel;

    /**
     * The total number of buffers in the underlying channel
     */
    private final int bufferCount;
    
    /**
     * Cached memory mapped source (which represents the current buffer).  This implements a simple MRU with a length of 1.
     * Future implementations may move to a more refined MRU allowing multiple areas of the channel to be buffered at the same time.
     */
    private ByteBufferRandomAccessSource currentSource;

    /**
     * The index of the current memory mapped source
     */
    private int currentSourceN = -1;
    
    
    /**
     * Cached size of the underlying channel
     */
    private final long size;

    /**
     * Constructs a new {@link FileChannelRandomAccessSource} based on the specified FileChannel, with a default buffer size
     * @param channel the channel to use as the backing store
     * @throws IOException if the channel cannot be opened or mapped
     */
    public FileChannelRandomAccessSource(FileChannel channel) throws IOException {
		this(channel, DEFAULT_BUFSIZE);
	}
    
    /**
     * Constructs a new {@link FileChannelRandomAccessSource} based on the specified FileChannel, with a specific buffer size
     * @param channel the channel to use as the backing store
     * @param bufferSize the size of the buffers to use
     * @throws IOException if the channel cannot be opened or mapped
     */
	public FileChannelRandomAccessSource(final FileChannel channel, final int bufferSize) throws IOException {
        this.channel = channel;
        this.bufferSize = bufferSize;
        
        size = channel.size();
        bufferCount = (int)(size/bufferSize) + (size % bufferSize == 0 ? 0 : 1);
        //System.out.println("This will require " + requiredBuffers + " buffers");

        //force a read of the last block in the file (this isn't strictly necessary, but it will force an early IOException if there are any gross problems with the file.  Most PDFs will read the last page of the file first, so this doesn't introduce an extra map operation in most cases).
        getBufferSourceForOffset(size-1);
	}

	/**
	 * Returns the buffered source that contains bytes at the specified offset.  A single depth MRU is used for efficiency.
	 * As buffered sources are evicted from the MRU, they are closed (releasing their underlying map)
	 * @param offset the offset of the position that is contained by the buffer
	 * @return the buffered source
	 * @throws IOException if there are problems creating the memory map
	 */
	private RandomAccessSource getBufferSourceForOffset(long offset) throws IOException {
        int mapN = (int) (offset / bufferSize);
        if (mapN > bufferCount)
        	return null;
        
		if (mapN != currentSourceN){
		
			if (!channel.isOpen()){
				throw new IllegalStateException("Channel is closed");
			}
			
			if (currentSource != null){
				currentSource.close();
				currentSource = null;
				currentSourceN = -1;
			}
			
			long pageOffset = (long)mapN * bufferSize;
			long size2 = Math.min(size - pageOffset, bufferSize);
			
			currentSource = new ByteBufferRandomAccessSource(channel.map(FileChannel.MapMode.READ_ONLY, pageOffset, size2));
			currentSourceN = mapN;
		}
		
		return currentSource;
		
	}
	
    /** 
     * {@inheritDoc} 
     */  
	public int get(long position) throws IOException {
    	RandomAccessSource source = getBufferSourceForOffset(position);
        int offN = (int) (position % bufferSize);

        if (source == null) // we have run out of data to read from
        	return -1;
        
        if (offN >= source.length())
            return -1;
        
        return source.get(offN);

	}
	
    /** 
     * {@inheritDoc} 
     */  
	public int get(long position, byte[] bytes, int off, int len) throws IOException {
    	RandomAccessSource source = getBufferSourceForOffset(position);
        int offN = (int) (position % bufferSize);
        int remaining = len;
        
        while(remaining > 0){
            if (source == null) // we have run out of data to read from
                break;
            if (offN > source.length())
                break;
            
            int count = source.get(offN, bytes, off, remaining);
            if (count == -1)
            	break;
            
            off += count;
            position += count;
            remaining -= count;

            offN = 0;
            
        	source = getBufferSourceForOffset(position);
        }
        return remaining == len ? -1 : len - remaining;	
    }

	
    /** 
     * {@inheritDoc} 
     */  
	public long length() {
		return size;
	}

    /**
     * @see java.io.RandomAccessFile#close()
     * Cleans the mapped bytebuffers and closes the channel
     */
    public void close() throws IOException {
        if (currentSource != null){
        	currentSource.close();
        	currentSourceN = -1;
        }

        channel.close();
        
    }

}
