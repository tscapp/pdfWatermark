package com.tsc;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfLayer;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.prism.paint.Color;


public class PdfWaterMark {
	public void addWaterMark(String sPartnerName, String sDate, String sUserName) throws IOException, DocumentException {
    	//Read Source Pdf file
    	PdfReader reader = new PdfReader("contract.pdf");
    	//Retrieve number of pages from the file
        int n = reader.getNumberOfPages();

        // Create a stamper that will copy the document to a new file
        PdfStamper stamp = new PdfStamper(reader,  new FileOutputStream("contractWaterMarked.pdf"));
        int i = 1;
        PdfContentByte cb;
        BaseFont bf = BaseFont.createFont("THSarabunNew.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        while (i < n)         {
			// Text under the existing page
			cb = stamp.getUnderContent(i);
			//Set font opacity
			PdfGState pdfgs = new PdfGState();
			pdfgs.setFillOpacity(0.4f);
			cb.setGState(pdfgs);
			//Set text rotation
			int rotate = 55;
	        cb.beginText();
	        cb.setFontAndSize(bf, 50);
            cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "Confidential " + sDate, 50, 200, rotate);
            cb.showTextAligned(PdfContentByte.ALIGN_LEFT, sPartnerName, 70, 100, rotate);
            cb.showTextAligned(PdfContentByte.ALIGN_LEFT, sUserName, 200, 150, rotate);
	        cb.endText();			
						
			i++;
        }
      
        stamp.close();    	
        System.out.println("Watermark completed");
    }
	
	public void addWaterMark(String sPartnerName, String sDate, String sUserName, String sourceFile, String destFile) throws IOException, DocumentException {
    	//Read Source Pdf file
    	PdfReader reader = new PdfReader(sourceFile);
    	//Retrieve number of pages from the file
        int n = reader.getNumberOfPages();

        // Create a stamper that will copy the document to a new file
        PdfStamper stamp = new PdfStamper(reader,  new FileOutputStream(destFile));
        int i = 1;
        PdfContentByte cb;
        BaseFont bf = BaseFont.createFont("THSarabunNew.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        while (i < n)         {
			// Text under the existing page
			cb = stamp.getUnderContent(i);
			//Set font opacity
			PdfGState pdfgs = new PdfGState();
			pdfgs.setFillOpacity(0.4f);
			cb.setGState(pdfgs);
			//Set text rotation
			int rotate = 55;
	        cb.beginText();
	        cb.setFontAndSize(bf, 50);
            cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "Confidential " + sDate, 50, 200, rotate);
            cb.showTextAligned(PdfContentByte.ALIGN_LEFT, sPartnerName, 70, 100, rotate);
            cb.showTextAligned(PdfContentByte.ALIGN_LEFT, sUserName, 200, 150, rotate);
	        cb.endText();			
						
			i++;
        }
      
        stamp.close();    	
        System.out.println("Watermark completed");
    }
 
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException 
     */
    public void createPdf(String filename)
	throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("Hello World!"));
        // step 5
        document.close();
    }
}
