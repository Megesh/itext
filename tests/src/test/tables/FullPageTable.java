/**
 * Example written by Bruno Lowagie in answer to:
 * http://stackoverflow.com/questions/19873263/how-to-increase-the-width-of-pdfptable-in-itext-pdf
 * 
 * We create a table with two columns and two cells.
 * This way, we can add two images next to each other.
 */
package test.tables;

import java.io.FileOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import test.SandboxTest;

public class FullPageTable extends SandboxTest {

    @Override
    protected String getOutPdf() {
        return "./results/tables/full_page_table.pdf";
    }

    @Override
    protected String getCmpPdf() {
        return "./resources/results/tables/cmp_full_page_table.pdf";
    }

    @Override
    public void makePdf(String outPdf) throws Exception {
        Document document = new Document(PageSize.A4, 0, 0, 0, 0);
        PdfWriter.getInstance(document, new FileOutputStream(outPdf));
        document.open();
        PdfPTable table = new PdfPTable(10);

        table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);

        // first row
        PdfPCell cell = new PdfPCell(new Phrase("DateRange"));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5.0f);
        cell.setBackgroundColor(new BaseColor(140, 221, 8));
        table.addCell(cell);

        table.addCell("Calldate");
        table.addCell("Calltime");
        table.addCell("Source");
        table.addCell("DialedNo");
        table.addCell("Extension");
        table.addCell("Trunk");
        table.addCell("Duration");
        table.addCell("Calltype");
        table.addCell("Callcost");
        table.addCell("Site");

        for (int i = 0; i < 100; i++) {
            table.addCell("date" + i);
            table.addCell("time" + i);
            table.addCell("source" + i);
            table.addCell("destination" + i);
            table.addCell("extension" + i);
            table.addCell("trunk" + i);
            table.addCell("dur" + i);
            table.addCell("toc" + i);
            table.addCell("callcost" + i);
            table.addCell("Site" + i);
        }
        document.add(table);
        document.close();
    }

    public static void main(String[] args) throws Exception {
        SandboxTest test = new FullPageTable();
        test.makePdf();
    }
}