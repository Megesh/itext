/*
 * $Id$
 * $Name$
 *
 * Copyright 1999, 2000, 2001 by Bruno Lowagie.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Library General Public License as published
 * by the Free Software Foundation; either version 2 of the License, or any
 * later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Library general Public License for more
 * details.
 *
 * You should have received a copy of the GNU Library General Public License along
 * with this library; if not, write to the Free Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA 02111-1307 USA.
 *
 * If you didn't download this code from the following link, you should check if
 * you aren't using an obsolete version:
 * http://www.lowagie.com/iText/
 *
 * ir-arch Bruno Lowagie,
 * Adolf Baeyensstraat 121
 * 9040 Sint-Amandsberg
 * BELGIUM
 * tel. +32 (0)9 228.10.97
 * bruno@lowagie.com
 *
 */

package com.lowagie.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

/**
 * A <CODE>Chapter</CODE> is a special <CODE>Section</CODE>.
 * <P>
 * A chapter number has to be created using a <CODE>Paragraph</CODE> as title
 * and an <CODE>int</CODE> as chapternumber. The chapter number is shown be
 * default. If you don't want to see the chapter number, you have to set the
 * numberdepth to <VAR>0</VAR>.
 * <P>
 * Example:
 * <BLOCKQUOTE><PRE>
 * Paragraph title2 = new Paragraph("This is Chapter 2", new Font(Font.HELVETICA, 18, Font.BOLDITALIC, new Color(0, 0, 255)));
 * <STRONG>Chapter chapter2 = new Chapter(title2, 2);</STRONG>
 * <STRONG>chapter2.setNumberDepth(0);</STRONG>
 * Paragraph someText = new Paragraph("This is some text");
 * <STRONG>chapter2.add(someText);</STRONG>
 * Paragraph title21 = new Paragraph("This is Section 1 in Chapter 2", new Font(Font.HELVETICA, 16, Font.BOLD, new Color(255, 0, 0)));
 * Section section1 = <STRONG>chapter2.addSection(title21);</STRONG>
 * Paragraph someSectionText = new Paragraph("This is some silly paragraph in a chapter and/or section. It contains some text to test the functionality of Chapters and Section.");
 * section1.add(someSectionText);
 * </PRE></BLOCKQUOTE>
 *
 * @author  bruno@lowagie.com
 */

public class Chapter extends Section implements TextElementArray {
    
    // constructors
    
/**
 * Constructs a new <CODE>Chapter</CODE>.
 *
 * @param	title		the Chapter title (as a <CODE>Paragraph</CODE>)
 * @param	number		the Chapter number
 */
    
    public Chapter(Paragraph title, int number) {
        super(title, 1);
        numbers = new ArrayList();
        numbers.add(new Integer(number));
    }
    
/**
 * Constructs a new <CODE>Chapter</CODE>.
 *
 * @param	title		the Chapter title (as a <CODE>String</CODE>)
 * @param	number		the Chapter number
 */
    
    public Chapter(String title, int number) {
        this(new Paragraph(title), number);
    }
    
/**
 * Creates a new <CODE>Chapter</CODE> following a set of attributes.
 *
 * @param	attributes	the attributes
 */
    
    public Chapter(Properties attributes, int number) {
        this(new Paragraph(""), number);
        
        String value;
        if ((value = attributes.getProperty(ElementTags.DEPTH)) != null) {
            setNumberDepth(Integer.parseInt(value));
        }
        if ((value = attributes.getProperty(ElementTags.INDENT)) != null) {
            setIndentation(Float.parseFloat(value + "f"));
        }
        if ((value = attributes.getProperty(ElementTags.INDENTATIONLEFT)) != null) {
            setIndentationLeft(Float.parseFloat(value + "f"));
        }
        if ((value = attributes.getProperty(ElementTags.INDENTATIONRIGHT)) != null) {
            setIndentationRight(Float.parseFloat(value + "f"));
        }
    }
    
    // implementation of the Element-methods
    
/**
 * Gets the type of the text element.
 *
 * @return	a type
 */
    
    public int type() {
        return Element.CHAPTER;
    }
    
    // methods
    
/**
 * Checks if a given tag corresponds with this object.
 *
 * @param   tag     the given tag
 * @return  true if the tag corresponds
 */
    
    public static boolean isTag(String tag) {
        return ElementTags.CHAPTER.equals(tag);
    }
        
/**
 * Returns the XML representation of this <CODE>Section</CODE>.
 *
 * @return		a <CODE>String</CODE>
 */
    
    public String toXml(int indent) {
        StringBuffer buf = new StringBuffer();
        DocWriter.addTabs(buf, indent);
        
        buf.append("<").append(ElementTags.CHAPTER);
        
        buf.append(" ").append(ElementTags.DEPTH).append("=\"").append(numberDepth);
        buf.append("\" ").append(ElementTags.INDENT).append("=\"").append(sectionIndent);
        if (indentationLeft != 0) {
            buf.append("\" ").append(ElementTags.INDENTATIONLEFT).append("=\"").append(indentationLeft);
        }
        if (indentationRight != 0) {
            buf.append("\" ").append(ElementTags.INDENTATIONRIGHT).append("=\"").append(indentationRight);
        }
        buf.append("\">\n");

        if (title != null) {        
            DocWriter.addTabs(buf, indent + 1);
            buf.append("<").append(ElementTags.TITLE).append(" ");
            buf.append(ElementTags.LEADING).append("=\"").append(title.leading());
            buf.append("\" ").append(ElementTags.ALIGN).append("=\"").append(ElementTags.getAlignment(title.alignment()));
            if (indentationLeft != 0) {
                buf.append("\" ").append(ElementTags.INDENTATIONLEFT).append("=\"");
                buf.append(indentationLeft);
            }
            if (indentationRight != 0) {
                buf.append("\" ").append(ElementTags.INDENTATIONRIGHT).append("=\"");
                buf.append(indentationRight);
            }
            buf.append("\">\n");
            for (Iterator i = title.iterator(); i.hasNext(); ) {
                buf.append(((Element)i.next()).toXml(indent + 2));
            }
            DocWriter.addTabs(buf, indent + 1);
            buf.append("</").append(ElementTags.TITLE).append(">\n");
        }
        for (Iterator i = iterator(); i.hasNext(); ) {
            buf.append(((Element)i.next()).toXml(indent + 1));
        }
        DocWriter.addTabs(buf, indent);
        buf.append("</").append(ElementTags.CHAPTER).append(">\n");
        return buf.toString();
    }
    
/**
 * Returns a representation of this <CODE>Section</CODE>.
 *
 * @return	a <CODE>String</CODE>
 */
    
    public String toString() {
        StringBuffer buf = new StringBuffer("<").append(ElementTags.CHAPTER).append(" ").append(ElementTags.DEPTH).append("=\"");
        buf.append(numberDepth);
        buf.append("\" ").append(ElementTags.INDENT).append("=\"");
        buf.append(sectionIndent);
        if (indentationLeft != 0) {
            buf.append("\" ").append(ElementTags.INDENTATIONLEFT).append("=\"");
            buf.append(indentationLeft);
        }
        if (indentationRight != 0) {
            buf.append("\" ").append(ElementTags.INDENTATIONRIGHT).append("=\"");
            buf.append(indentationRight);
        }
        buf.append("\">\n");
        if (title != null) {
            buf.append("<").append(ElementTags.TITLE).append(" ").append(ElementTags.LEADING).append("=\"");
            buf.append(title.leading());
            buf.append("\" ").append(ElementTags.ALIGN).append("=\"");
            buf.append(ElementTags.getAlignment(title.alignment()));
            if (indentationLeft != 0) {
                buf.append("\" ").append(ElementTags.INDENTATIONLEFT).append("=\"");
                buf.append(indentationLeft);
            }
            if (indentationRight != 0) {
                buf.append("\" ").append(ElementTags.INDENTATIONRIGHT).append("=\"");
                buf.append(indentationRight);
            }
            buf.append("\">");
            for (Iterator i = title.iterator(); i.hasNext(); ) {
                buf.append(i.next().toString());
            }
            buf.append("</").append(ElementTags.TITLE).append(">\n");
        }
        for (Iterator i = iterator(); i.hasNext(); ) {
            buf.append(i.next().toString());
        }
        buf.append("</").append(ElementTags.CHAPTER).append(">\n");
        return buf.toString();
    }
}