package com.tsc;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class Main {

	public static void main(String[] args) throws DocumentException, IOException {
		PdfWaterMark pdfwatermark = new PdfWaterMark();
		pdfwatermark.createPdf("test.pdf");
		
	}

}
