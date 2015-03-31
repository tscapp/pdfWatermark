package com.tsc;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class Main {

	public static void main(String[] args) {
		PdfWaterMark pdfwatermark = new PdfWaterMark();
		try {
			pdfwatermark.addWaterMark("บริษัท กรุงเทพมหานครอมรรัตรโกสินทร์มหินทรายุธยามหาดิลกภพนพรัตนราชธานีบูรีรมย์", "20150315", "John Heng");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		System.out.println("test");
	}
}
