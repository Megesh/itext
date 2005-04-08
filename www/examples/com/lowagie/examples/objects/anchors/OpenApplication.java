/*
 * $Id$
 * $Name$
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://itext.sourceforge.net/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */

package com.lowagie.examples.objects.anchors;

import java.io.FileOutputStream;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Creates a documents with different named actions.
 * 
 * @author blowagie
 */

public class OpenApplication {

	/**
	 * Creates a document with Named Actions.
	 * 
	 * @param args
	 *            the system root (for instance "C:\windows\")
	 */
	public static void main(String[] args) {

		System.out.println("Open Application");

		// step 1: creation of a document-object
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		try {

			// step 2: we create a writer that listens to the document
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("OpenApplication.pdf"));
			// step 3: we open the document
			document.open();
			// step 4: we add some content
			String application = args[0] + "notepad.exe";
			Paragraph p = new Paragraph(new Chunk("Click to open "
					+ application).setAction(new PdfAction(application, null,
					null, null)));
			document.add(p);
		} catch (Exception de) {
			de.printStackTrace();
		}

		// step 5: we close the document
		document.close();

	}
}