package com.ghosh.jaagteyRaho.service.PdfGeneration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.ghosh.jaagteyRahoBackend.dto.Client;
import com.ghosh.jaagteyRahoBackend.dto.Site;
import com.ghosh.jaagteyRahoBackend.dto.User;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGeneration {

	public static void generateEmpPdf(HttpServletResponse response,
			List<User> employees) throws DocumentException {
		response.setContentType("application/pdf");
		Document document = new Document(PageSize.A4.rotate());
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document,
				byteArrayOutputStream);
		document.open();
		Font font1 = new Font(Font.FontFamily.UNDEFINED, 20);

		PdfPTable table;
		PdfPCell cell;

		table = new PdfPTable(1);
		table.setWidthPercentage(100);
		float[] columnWidths = new float[] { 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk("Employee Details", font1)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(.5f);
		cell.setBorderColor(new BaseColor(146, 144, 144));
		cell.setPadding(0);
		cell.setPaddingBottom(15f);
		cell.setPaddingLeft(12f);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(8);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 0.7f, 2f, 3f, 4f, 2f, 2f, 2f, 2f };
		table.setWidths(columnWidths);
		Font font = new Font(Font.FontFamily.UNDEFINED, 10);
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
		cell = new PdfPCell(new Phrase(new Chunk("Emp ID", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Name", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Email ID", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("DOB", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Contact No", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Role", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Designation", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);

		int i = 0;
		for (User user : employees) {
			i++;
			font = new Font(Font.FontFamily.UNDEFINED, 10);
			cell = new PdfPCell(new Phrase(new Chunk(String.valueOf(i), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(user.getEmpId(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			String name = "";
			if (user.getMiddleName() == null || user.getMiddleName().equals("")) {
				name = user.getFirstName() + " " + user.getLastName();
			} else {
				name = user.getFirstName() + " " + user.getMiddleName() + " "
						+ user.getLastName();
			}
			cell = new PdfPCell(new Phrase(new Chunk(name, font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(user.getEmail(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(user.getDob(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(user.getContactNumber(),
					font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(user.getRole(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(user.getDesignation()
					.getDesignationName(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
		}

		document.add(table);
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
			e.printStackTrace();
		}
	}

	public static void generateEmpClient(HttpServletResponse response,
			List<Client> clients) throws DocumentException {
		response.setContentType("application/pdf");
		Document document = new Document(PageSize.A4.rotate());
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document,
				byteArrayOutputStream);
		document.open();
		Font font1 = new Font(Font.FontFamily.UNDEFINED, 20);

		PdfPTable table;
		PdfPCell cell;

		table = new PdfPTable(1);
		table.setWidthPercentage(100);
		float[] columnWidths = new float[] { 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk("Client Details", font1)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(.5f);
		cell.setBorderColor(new BaseColor(146, 144, 144));
		cell.setPadding(0);
		cell.setPaddingBottom(15f);
		cell.setPaddingLeft(12f);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(7);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 0.7f, 3f, 3f, 3f, 3f, 5f, 7f };
		table.setWidths(columnWidths);
		Font font = new Font(Font.FontFamily.UNDEFINED, 10);
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
		cell = new PdfPCell(new Phrase(new Chunk("Client Code", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Client Name", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Contact Person", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Contact No", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Email ID", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Address", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);

		int i = 0;
		for (Client client : clients) {
			i++;
			font = new Font(Font.FontFamily.UNDEFINED, 10);
			cell = new PdfPCell(new Phrase(new Chunk(String.valueOf(i), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(client.getClientCode(),
					font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(client.getClientName(),
					font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(client.getContactPerson(),
					font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(client.getContactNo(),
					font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(
					new Phrase(new Chunk(client.getEmailId(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(
					new Phrase(new Chunk(client.getAddress(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
		}

		document.add(table);
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
			e.printStackTrace();
		}
	}

	public static void generateSitePdf(HttpServletResponse response,
			List<Site> sites) throws DocumentException {
		response.setContentType("application/pdf");
		Document document = new Document(PageSize.A4.rotate());
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document,
				byteArrayOutputStream);
		document.open();
		Font font1 = new Font(Font.FontFamily.UNDEFINED, 20);

		PdfPTable table;
		PdfPCell cell;

		table = new PdfPTable(1);
		table.setWidthPercentage(100);
		float[] columnWidths = new float[] { 1f };
		table.setWidths(columnWidths);
		cell = new PdfPCell(new Phrase(new Chunk("Site Details", font1)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(.5f);
		cell.setBorderColor(new BaseColor(146, 144, 144));
		cell.setPadding(0);
		cell.setPaddingBottom(15f);
		cell.setPaddingLeft(12f);
		table.addCell(cell);
		document.add(table);

		table = new PdfPTable(8);
		table.setWidthPercentage(100);
		columnWidths = new float[] { 0.7f, 3f, 3f, 3f, 3f, 3f, 5f, 7f };
		table.setWidths(columnWidths);
		Font font = new Font(Font.FontFamily.UNDEFINED, 10);
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
		cell = new PdfPCell(new Phrase(new Chunk("Site Code", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Site Name", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Client", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setBorderWidthBottom(0.5f);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Contact Person", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Contact No", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Email ID", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Chunk("Address", font)));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorderWidth(0f);
		cell.setBorderWidthBottom(0.5f);
		cell.setBorderColor(new BaseColor(233, 233, 233));
		cell.setPadding(0);
		cell.setPaddingTop(5);
		cell.setPaddingLeft(6);
		cell.setPaddingBottom(9);
		cell.setBackgroundColor(new BaseColor(207, 207, 207));
		table.addCell(cell);

		int i = 0;
		for (Site site : sites) {
			i++;
			font = new Font(Font.FontFamily.UNDEFINED, 10);
			cell = new PdfPCell(new Phrase(new Chunk(String.valueOf(i), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(site.getSiteCode(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(site.getSiteName(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(site.getClient()
					.getClientName(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(site.getContactPerson(),
					font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(
					new Phrase(new Chunk(site.getContactNo(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(site.getEmailId(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(new Chunk(site.getAddress(), font)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorderWidth(0f);
			cell.setBorderWidthBottom(0.5f);
			cell.setBorderColor(new BaseColor(204, 204, 204));
			cell.setPadding(0);
			cell.setPaddingLeft(6);
			cell.setPaddingTop(7);
			cell.setPaddingBottom(9);
			table.addCell(cell);
		}

		document.add(table);
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
			e.printStackTrace();
		}
	}
}
