package com.ghosh.jaagteyRaho.service.PdfGeneration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGeneration {

	public void generateBill(HttpServletRequest requests,
			HttpServletResponse response) throws DocumentException {
		response.setContentType("application/pdf");
		Document document = new Document(PageSize.A4.rotate());
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document,
				byteArrayOutputStream);
		document.open();
		Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 40);
		Font font2 = new Font(Font.FontFamily.UNDEFINED, 14);
		Font font3 = new Font(Font.FontFamily.UNDEFINED, 10);
		Font font4 = new Font(Font.FontFamily.UNDEFINED, 12);

		PdfPTable table;
		PdfPCell cell;

		table = new PdfPTable(2);
		table.setWidthPercentage(100);
		float[] columnWidths = new float[] { 1f, 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk("SLATE", font1)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(.5f);
		cell.setBorderColor(new BaseColor(146, 144, 144));
		cell.setPadding(0);
		cell.setPaddingBottom(8);
		cell.setPaddingLeft(12f);
		table.addCell(cell);
		font1 = new Font(Font.FontFamily.TIMES_ROMAN, 14);
		cell = new PdfPCell(new Phrase(new Chunk("Payment Receipt", font1)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(.5f);
		cell.setBorderColor(new BaseColor(146, 144, 144));
		cell.setPadding(0);
		cell.setPaddingRight(7f);
		cell.setPaddingBottom(8);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(1);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk(" ", new Font(
				Font.FontFamily.TIMES_ROMAN, 8))));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setFixedHeight(2f);
		cell.setPadding(0);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(2);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 3f, 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell();
		Paragraph para = new Paragraph();
		para.add(new Chunk("IBM India Pvt Ltd", font2));
		cell.addElement(para);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		para = new Paragraph();
		para.add(new Chunk("Anurag Ghosh", font4));
		cell.addElement(para);
		para = new Paragraph();
		para.add(new Chunk("Deepandhu House, House no 247", font3));
		cell.addElement(para);
		para = new Paragraph();
		para.add(new Chunk("GURUGRAM-122001", font3));
		cell.addElement(para);
		para = new Paragraph();
		para.add(new Chunk("near citi bank ATM-India ", font3));
		cell.addElement(para);
		para = new Paragraph();
		para.add(new Chunk("P : (817) 190-8867", font3));
		cell.addElement(para);

		/*-cell = new PdfPCell(
				new Phrase(new Chunk("Compliance ScoreCard", font2)));*/
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setPadding(0);
		cell.setPaddingTop(12);
		table.addCell(cell);
		cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		para = new Paragraph();
		para.add(new Chunk("Payment No : ", font4));
		para.add(new Chunk("#AA-454-4113-00", font3));
		cell.addElement(para);
		para = new Paragraph();
		para.add(new Chunk("Payment Date : ", font4));
		para.add(new Chunk("01-May-2018", font3));
		cell.addElement(para);
		para = new Paragraph();
		para.add(new Chunk("Payment Duration : ", font4));
		para.add(new Chunk("Monthly", font3));
		cell.addElement(para);
		font4 = new Font(Font.FontFamily.UNDEFINED, 14, Font.BOLD,
				BaseColor.WHITE);

		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setBorderWidth(0f);
		cell.setPadding(0);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(1);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk(" ", new Font(
				Font.FontFamily.TIMES_ROMAN, 8))));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setFixedHeight(17f);
		cell.setPadding(0);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(5);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 0.5f, 2f, 4f, 1f, 1f };
		table.setWidths(columnWidths);
		Font font = new Font(Font.FontFamily.UNDEFINED, 10);
		// font.setColor(new BaseColor(255, 255, 255));
		cell = new PdfPCell(new Phrase(new Chunk("#", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(0);
		cell.setPaddingLeft(6);
		cell.setPaddingTop(5);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("ITEM", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("DESCRIPTION", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(6);
		cell.setPaddingTop(5);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("PRICE", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("SUB TOTAL", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(5);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 0.5f, 2f, 4f, 1f, 1f };
		table.setWidths(columnWidths);
		font = new Font(Font.FontFamily.UNDEFINED, 10);
		// font.setColor(new BaseColor(255, 255, 255));
		cell = new PdfPCell(new Phrase(new Chunk("1", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(204, 204, 204));
		// cell.setBackgroundColor(new BaseColor(101, 99, 99));
		cell.setPadding(0);
		cell.setPaddingLeft(7);
		cell.setPaddingTop(7);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		Font fonts = new Font(Font.FontFamily.UNDEFINED, 10);
		fonts.setColor(new BaseColor(12, 12, 255));
		cell = new PdfPCell(new Phrase(new Chunk("Amazon Web Services", fonts)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(204, 204, 204));
		// cell.setBackgroundColor(new BaseColor(101, 99, 99));
		cell.setPadding(0);
		cell.setPaddingTop(7);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk(
				"This feature will provide to save create instances of server",
				font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(204, 204, 204));
		// cell.setBackgroundColor(new BaseColor(101, 99, 99));
		cell.setPadding(6);
		cell.setPaddingTop(7);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("\u20B9 1.0 /-", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(204, 204, 204));
		cell.setPadding(0);
		cell.setPaddingTop(7);
		cell.setPaddingBottom(9);
		// cell.setBackgroundColor(new BaseColor(101, 99, 99));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("\u20B9 1.0 /-", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(204, 204, 204));
		cell.setPadding(0);
		cell.setPaddingTop(7);
		cell.setPaddingBottom(9);
		// cell.setBackgroundColor(new BaseColor(101, 99, 99));
		table.addCell(cell);

		font = new Font(Font.FontFamily.UNDEFINED, 10);
		// font.setColor(new BaseColor(255, 255, 255));
		cell = new PdfPCell(new Phrase(new Chunk("Total", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(204, 204, 204));
		cell.setColspan(4);
		cell.setPadding(0);
		cell.setPaddingLeft(7);
		cell.setPaddingTop(7);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		font = new Font(Font.FontFamily.UNDEFINED, 10);
		// font.setColor(new BaseColor(255, 255, 255));
		cell = new PdfPCell(new Phrase(new Chunk("1.0 /-", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(204, 204, 204));
		cell.setColspan(4);
		cell.setPadding(0);
		cell.setPaddingLeft(3f);
		cell.setPaddingTop(7);
		cell.setPaddingBottom(9);
		table.addCell(cell);

		font = new Font(Font.FontFamily.UNDEFINED, 10);
		cell = new PdfPCell(new Phrase(new Chunk("Service Tax", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(204, 204, 204));
		cell.setColspan(4);
		cell.setPadding(0);
		cell.setPaddingLeft(7);
		cell.setPaddingTop(7);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		font = new Font(Font.FontFamily.UNDEFINED, 10);
		// font.setColor(new BaseColor(255, 255, 255));
		cell = new PdfPCell(new Phrase(new Chunk("12.0 %", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(204, 204, 204));
		cell.setColspan(4);
		cell.setPadding(0);
		cell.setPaddingLeft(3f);
		cell.setPaddingTop(7);
		cell.setPaddingBottom(9);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(new Chunk("", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setBorderWidth(0f);
		cell.setColspan(3);
		cell.setPadding(0);
		table.addCell(cell);

		font = new Font(Font.FontFamily.UNDEFINED, 14, Font.BOLD,
				BaseColor.WHITE);
		cell = new PdfPCell(new Phrase(new Chunk("Total : 1.12 /-", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBackgroundColor(new BaseColor(0, 0, 0));
		cell.setColspan(2);
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingBottom(7);
		table.addCell(cell);

		document.add(table);

		int i = 1;
		font = new Font(Font.FontFamily.TIMES_ROMAN, 10);

		document.close();

		System.out.println("size of document is [" + document + "]");
		System.out.println("size of byte input stream is ["
				+ byteArrayOutputStream.size() + "]");

		byte[] blob = byteArrayOutputStream.toByteArray();
		response.setContentLength(blob.length);
		System.out.println("size of blob object is [" + blob.length + "]");
		ServletOutputStream out;
		try {
			out = response.getOutputStream();
			out.write(blob);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void generateTrailPdf(HttpServletRequest requests,
			HttpServletResponse response) throws IOException, DocumentException {
		response.setContentType("application/pdf");
		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document,
				byteArrayOutputStream);
		document.open();
		Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 20);
		Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 14);
		Font font3 = new Font(Font.FontFamily.TIMES_ROMAN, 12);

		PdfPTable table;
		PdfPCell cell;

		table = new PdfPTable(1);
		table.setWidthPercentage(100);
		float[] columnWidths = new float[] { 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk("Account Submission Trail",
				font1)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(.5f);
		cell.setBorderColor(new BaseColor(146, 144, 144));
		cell.setPadding(0);
		cell.setPaddingBottom(8);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(1);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk(" ", new Font(
				Font.FontFamily.TIMES_ROMAN, 8))));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setFixedHeight(2f);
		cell.setPadding(0);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(4);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 1f, 2f, 1f, 2f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk("Dept Code", font3)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBackgroundColor(new BaseColor(243, 243, 243));
		cell.setBorderWidth(0f);
		cell.setPadding(0);
		cell.setPaddingLeft(8);
		cell.setPaddingBottom(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("D48")));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setPadding(0);
		cell.setBackgroundColor(new BaseColor(243, 243, 243));
		cell.setPaddingBottom(8);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(new Chunk("Account Name", font3)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setPadding(0);
		cell.setBackgroundColor(new BaseColor(243, 243, 243));
		cell.setPaddingBottom(8);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("D48")));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setPadding(0);
		cell.setBackgroundColor(new BaseColor(243, 243, 243));
		cell.setPaddingBottom(8);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(new Chunk("Competency", font3)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setPadding(0);
		cell.setPaddingLeft(8);
		cell.setPaddingBottom(8);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("D48")));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setPadding(0);
		cell.setPaddingBottom(8);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(new Chunk("Location", font3)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setPadding(0);
		cell.setPaddingBottom(8);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("D48")));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setPadding(0);
		cell.setPaddingBottom(8);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(1);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk(" ", new Font(
				Font.FontFamily.TIMES_ROMAN, 8))));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(.5f);
		cell.setBorderColor(new BaseColor(146, 144, 144));
		cell.setFixedHeight(2f);
		cell.setPadding(0);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(1);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk(" ", new Font(
				Font.FontFamily.TIMES_ROMAN, 8))));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setFixedHeight(7f);
		cell.setPadding(0);
		table.addCell(cell);
		document.add(table);

		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12);
		int i = 1;
		font = new Font(Font.FontFamily.TIMES_ROMAN, 10);

		document.close();

		System.out.println("size of document is [" + document + "]");
		System.out.println("size of byte input stream is ["
				+ byteArrayOutputStream.size() + "]");

		byte[] blob = byteArrayOutputStream.toByteArray();
		response.setContentLength(blob.length);
		System.out.println("size of blob object is [" + blob.length + "]");
		ServletOutputStream out = response.getOutputStream();
		out.write(blob);
		out.close();
	}
}
