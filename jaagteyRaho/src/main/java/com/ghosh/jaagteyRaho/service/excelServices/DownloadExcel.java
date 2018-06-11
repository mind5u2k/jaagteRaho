package com.ghosh.jaagteyRaho.service.excelServices;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

import com.ghosh.jaagteyRaho.model.SiteEmpReport;
import com.ghosh.jaagteyRahoBackend.dto.Client;
import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;
import com.ghosh.jaagteyRahoBackend.dto.Designation;
import com.ghosh.jaagteyRahoBackend.dto.Site;
import com.ghosh.jaagteyRahoBackend.dto.SiteEmployeeMapping;
import com.ghosh.jaagteyRahoBackend.dto.User;

public class DownloadExcel {

	public static void downloadEmployeeExcel(HttpServletResponse response,
			List<User> users) {

		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFCellStyle style = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.WHITE.index);
		font.setFontName(HSSFFont.FONT_ARIAL);
		style.setFont(font);
		style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setWrapText(true);

		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setWrapText(true);
		style1.setAlignment(CellStyle.ALIGN_LEFT);
		HSSFSheet sheet = wb.createSheet();
		sheet.setColumnWidth(0, 1700);
		sheet.setColumnWidth(1, 2200);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 4000);
		sheet.setColumnWidth(4, 4000);
		sheet.setColumnWidth(5, 7000);
		sheet.setColumnWidth(6, 4000);
		sheet.setColumnWidth(7, 4000);
		sheet.setColumnWidth(8, 4000);
		sheet.setColumnWidth(9, 3000);
		sheet.setColumnWidth(10, 3000);
		sheet.setColumnWidth(11, 4000);
		sheet.setColumnWidth(12, 9000);
		sheet.setColumnWidth(13, 7000);
		sheet.setColumnWidth(14, 7000);
		sheet.setColumnWidth(15, 7000);
		sheet.setColumnWidth(16, 9000);
		sheet.setColumnWidth(17, 7000);
		sheet.setColumnWidth(18, 7000);
		sheet.setColumnWidth(19, 7000);
		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(25f);
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("S.No.");
		cell = row.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("Emp Id");
		cell = row.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("First Name");
		cell = row.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("Middle Name");
		cell = row.createCell(4);
		cell.setCellStyle(style);
		cell.setCellValue("Last Name");
		cell = row.createCell(5);
		cell.setCellStyle(style);
		cell.setCellValue("Email Id");
		cell = row.createCell(6);
		cell.setCellStyle(style);
		cell.setCellValue("D.O.B.");
		cell = row.createCell(7);
		cell.setCellStyle(style);
		cell.setCellValue("Contact No.");
		cell = row.createCell(8);
		cell.setCellStyle(style);
		cell.setCellValue("Alternate No.");
		cell = row.createCell(9);
		cell.setCellStyle(style);
		cell.setCellValue("Role");
		cell = row.createCell(10);
		cell.setCellStyle(style);
		cell.setCellValue("Gender");
		cell = row.createCell(11);
		cell.setCellStyle(style);
		cell.setCellValue("Designation");
		cell = row.createCell(12);
		cell.setCellStyle(style);
		cell.setCellValue("Correspondence Address");
		cell = row.createCell(13);
		cell.setCellStyle(style);
		cell.setCellValue("Correspondence PostalCode");
		cell = row.createCell(14);
		cell.setCellStyle(style);
		cell.setCellValue("Correspondence State");
		cell = row.createCell(15);
		cell.setCellStyle(style);
		cell.setCellValue("Correspondence City");
		cell = row.createCell(16);
		cell.setCellStyle(style);
		cell.setCellValue("Permanent Address");
		cell = row.createCell(17);
		cell.setCellStyle(style);
		cell.setCellValue("Permanent PostalCode");
		cell = row.createCell(18);
		cell.setCellStyle(style);
		cell.setCellValue("Permanent State");
		cell = row.createCell(19);
		cell.setCellStyle(style);
		cell.setCellValue("Permanent City");
		int rows = 1;
		int i = 0;

		for (User user : users) {
			i++;
			row = sheet.createRow(rows);
			cell = row.createCell(0);
			cell.setCellStyle(style1);
			cell.setCellValue(i);
			cell = row.createCell(1);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getEmpId());
			cell = row.createCell(2);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getFirstName());
			cell = row.createCell(3);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getMiddleName());
			cell = row.createCell(4);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getLastName());
			cell = row.createCell(5);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getEmail());
			cell = row.createCell(6);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getDob());
			cell = row.createCell(7);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getContactNumber());
			cell = row.createCell(8);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getAlternateNumber());
			cell = row.createCell(9);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getRole());
			cell = row.createCell(10);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getGender());
			cell = row.createCell(11);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getDesignation().getDesignationName());
			cell = row.createCell(12);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getCorredpondenceAddress());
			cell = row.createCell(13);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getCorredpondencePostalCode());
			cell = row.createCell(14);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getCorredpondenceState());
			cell = row.createCell(15);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getCorredpondenceCity());
			cell = row.createCell(16);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getPermanentAddress());
			cell = row.createCell(17);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getPermanentPostalCode());
			cell = row.createCell(18);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getPermanentState());
			cell = row.createCell(19);
			cell.setCellStyle(style1);
			cell.setCellValue(user.getPermanentCity());
			rows++;
		}

		// write it as an excel attachment
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		try {
			wb.write(outByteStream);
			byte[] outArray = outByteStream.toByteArray();
			response.setContentType("application/ms-excel");
			response.setContentLength(outArray.length);
			response.setHeader("Expires:", "0"); // eliminates browser caching
			response.setHeader("Content-Disposition",
					"attachment; filename=Employees.xls");
			OutputStream outStream = response.getOutputStream();
			outStream.write(outArray);
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void downloadClientExcel(HttpServletResponse response,
			List<Client> clients) {

		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFCellStyle style = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.WHITE.index);
		font.setFontName(HSSFFont.FONT_ARIAL);
		style.setFont(font);
		style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setWrapText(true);

		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setWrapText(true);
		style1.setAlignment(CellStyle.ALIGN_LEFT);
		HSSFSheet sheet = wb.createSheet();
		sheet.setColumnWidth(0, 1700);
		sheet.setColumnWidth(1, 3000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 4000);
		sheet.setColumnWidth(4, 4000);
		sheet.setColumnWidth(5, 6000);
		sheet.setColumnWidth(6, 8000);

		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(25f);
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("S.No.");
		cell = row.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("Client code");
		cell = row.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("Client Name");
		cell = row.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("Contact Person");
		cell = row.createCell(4);
		cell.setCellStyle(style);
		cell.setCellValue("Contact No");
		cell = row.createCell(5);
		cell.setCellStyle(style);
		cell.setCellValue("Email ID");
		cell = row.createCell(6);
		cell.setCellStyle(style);
		cell.setCellValue("Address");

		int rows = 1;
		int i = 0;

		for (Client client : clients) {
			i++;
			row = sheet.createRow(rows);
			cell = row.createCell(0);
			cell.setCellStyle(style1);
			cell.setCellValue(i);
			cell = row.createCell(1);
			cell.setCellStyle(style1);
			cell.setCellValue(client.getClientCode());
			cell = row.createCell(2);
			cell.setCellStyle(style1);
			cell.setCellValue(client.getClientName());
			cell = row.createCell(3);
			cell.setCellStyle(style1);
			cell.setCellValue(client.getContactPerson());
			cell = row.createCell(4);
			cell.setCellStyle(style1);
			cell.setCellValue(client.getContactNo());
			cell = row.createCell(5);
			cell.setCellStyle(style1);
			cell.setCellValue(client.getEmailId());
			cell = row.createCell(6);
			cell.setCellStyle(style1);
			cell.setCellValue(client.getAddress());
			rows++;
		}

		// write it as an excel attachment
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		try {
			wb.write(outByteStream);
			byte[] outArray = outByteStream.toByteArray();
			response.setContentType("application/ms-excel");
			response.setContentLength(outArray.length);
			response.setHeader("Expires:", "0"); // eliminates browser caching
			response.setHeader("Content-Disposition",
					"attachment; filename=Clients.xls");
			OutputStream outStream = response.getOutputStream();
			outStream.write(outArray);
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void downloadSiteExcel(HttpServletResponse response,
			List<Site> sites) {

		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFCellStyle style = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.WHITE.index);
		font.setFontName(HSSFFont.FONT_ARIAL);
		style.setFont(font);
		style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setWrapText(true);

		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setWrapText(true);
		style1.setAlignment(CellStyle.ALIGN_LEFT);
		HSSFSheet sheet = wb.createSheet();
		sheet.setColumnWidth(0, 1700);
		sheet.setColumnWidth(1, 3000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 5000);
		sheet.setColumnWidth(4, 4000);
		sheet.setColumnWidth(5, 4000);
		sheet.setColumnWidth(6, 6000);
		sheet.setColumnWidth(7, 8000);

		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(25f);
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("S.No.");
		cell = row.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("Site code");
		cell = row.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("Site Name");
		cell = row.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("Client");
		cell = row.createCell(4);
		cell.setCellStyle(style);
		cell.setCellValue("Contact Person");
		cell = row.createCell(5);
		cell.setCellStyle(style);
		cell.setCellValue("Contact No");
		cell = row.createCell(6);
		cell.setCellStyle(style);
		cell.setCellValue("Email ID");
		cell = row.createCell(7);
		cell.setCellStyle(style);
		cell.setCellValue("Address");

		int rows = 1;
		int i = 0;

		for (Site site : sites) {
			i++;
			row = sheet.createRow(rows);
			cell = row.createCell(0);
			cell.setCellStyle(style1);
			cell.setCellValue(i);
			cell = row.createCell(1);
			cell.setCellStyle(style1);
			cell.setCellValue(site.getSiteCode());
			cell = row.createCell(2);
			cell.setCellStyle(style1);
			cell.setCellValue(site.getSiteName());
			cell = row.createCell(3);
			cell.setCellStyle(style1);
			cell.setCellValue(site.getClient().getClientName());
			cell = row.createCell(4);
			cell.setCellStyle(style1);
			cell.setCellValue(site.getContactPerson());
			cell = row.createCell(5);
			cell.setCellStyle(style1);
			cell.setCellValue(site.getContactNo());
			cell = row.createCell(6);
			cell.setCellStyle(style1);
			cell.setCellValue(site.getEmailId());
			cell = row.createCell(7);
			cell.setCellStyle(style1);
			cell.setCellValue(site.getAddress());
			rows++;
		}

		// write it as an excel attachment
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		try {
			wb.write(outByteStream);
			byte[] outArray = outByteStream.toByteArray();
			response.setContentType("application/ms-excel");
			response.setContentLength(outArray.length);
			response.setHeader("Expires:", "0"); // eliminates browser caching
			response.setHeader("Content-Disposition",
					"attachment; filename=Sites.xls");
			OutputStream outStream = response.getOutputStream();
			outStream.write(outArray);
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void downloadEmployeeSiteExcel(HttpServletResponse response,
			List<SiteEmpReport> reports) {

		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFCellStyle style = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.WHITE.index);
		font.setFontName(HSSFFont.FONT_ARIAL);
		style.setFont(font);
		style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setWrapText(true);

		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setWrapText(true);
		style1.setAlignment(CellStyle.ALIGN_LEFT);
		HSSFSheet sheet = wb.createSheet();
		sheet.setColumnWidth(0, 1700);
		sheet.setColumnWidth(1, 3000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 3000);
		sheet.setColumnWidth(4, 4000);
		sheet.setColumnWidth(5, 8000);
		sheet.setColumnWidth(6, 9000);

		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(25f);
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("S.No.");
		cell = row.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("Client code");
		cell = row.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("Client Name");
		cell = row.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("Site code");
		cell = row.createCell(4);
		cell.setCellStyle(style);
		cell.setCellValue("Site Name");
		cell = row.createCell(5);
		cell.setCellStyle(style);
		cell.setCellValue("Site Address");
		cell = row.createCell(6);
		cell.setCellStyle(style);
		cell.setCellValue("Assigned Employees");

		int rows = 1;
		int i = 0;

		for (SiteEmpReport report : reports) {
			i++;
			row = sheet.createRow(rows);
			cell = row.createCell(0);
			cell.setCellStyle(style1);
			cell.setCellValue(i);
			cell = row.createCell(1);
			cell.setCellStyle(style1);
			cell.setCellValue(report.getSite().getClient().getClientCode());
			cell = row.createCell(2);
			cell.setCellStyle(style1);
			cell.setCellValue(report.getSite().getClient().getClientName());
			cell = row.createCell(3);
			cell.setCellStyle(style1);
			cell.setCellValue(report.getSite().getSiteCode());
			cell = row.createCell(4);
			cell.setCellStyle(style1);
			cell.setCellValue(report.getSite().getSiteName());
			cell = row.createCell(5);
			cell.setCellStyle(style1);
			cell.setCellValue(report.getSite().getAddress());
			cell = row.createCell(6);
			cell.setCellStyle(style1);

			String employees = "";
			for (SiteEmployeeMapping u : report.getMappings()) {
				if (employees.equals("")) {
					if (u.getEmployee().getMiddleName() == null
							|| u.getEmployee().getMiddleName().equals("")) {
						employees = u.getEmployee().getFirstName() + " "
								+ u.getEmployee().getLastName();
					} else {
						employees = u.getEmployee().getFirstName() + " "
								+ u.getEmployee().getMiddleName() + " "
								+ u.getEmployee().getLastName();
					}
				} else {
					if (u.getEmployee().getMiddleName() == null
							|| u.getEmployee().getMiddleName().equals("")) {
						employees = employees + ","
								+ u.getEmployee().getFirstName() + " "
								+ u.getEmployee().getLastName();
					} else {
						employees = employees + ","
								+ u.getEmployee().getFirstName() + " "
								+ u.getEmployee().getMiddleName() + " "
								+ u.getEmployee().getLastName();
					}
				}
			}
			cell.setCellValue(employees);
			rows++;
		}

		// write it as an excel attachment
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		try {
			wb.write(outByteStream);
			byte[] outArray = outByteStream.toByteArray();
			response.setContentType("application/ms-excel");
			response.setContentLength(outArray.length);
			response.setHeader("Expires:", "0"); // eliminates browser caching
			response.setHeader("Content-Disposition",
					"attachment; filename=EmployeeSiteReport.xls");
			OutputStream outStream = response.getOutputStream();
			outStream.write(outArray);
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void downloadDesignationsExcel(HttpServletResponse response,
			List<Designation> designations) {

		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFCellStyle style = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.WHITE.index);
		font.setFontName(HSSFFont.FONT_ARIAL);
		style.setFont(font);
		style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setWrapText(true);

		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setWrapText(true);
		style1.setAlignment(CellStyle.ALIGN_LEFT);
		HSSFSheet sheet = wb.createSheet();
		sheet.setColumnWidth(0, 1700);
		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 6000);

		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(25f);
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("S.No.");
		cell = row.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("Designation Code");
		cell = row.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("Designation Name");

		int rows = 1;
		int i = 0;

		for (Designation designation : designations) {
			i++;
			row = sheet.createRow(rows);
			cell = row.createCell(0);
			cell.setCellStyle(style1);
			cell.setCellValue(i);
			cell = row.createCell(1);
			cell.setCellStyle(style1);
			cell.setCellValue(designation.getDesignationCode());
			cell = row.createCell(2);
			cell.setCellStyle(style1);
			cell.setCellValue(designation.getDesignationName());
			rows++;
		}

		// write it as an excel attachment
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		try {
			wb.write(outByteStream);
			byte[] outArray = outByteStream.toByteArray();
			response.setContentType("application/ms-excel");
			response.setContentLength(outArray.length);
			response.setHeader("Expires:", "0"); // eliminates browser caching
			response.setHeader("Content-Disposition",
					"attachment; filename=Designations.xls");
			OutputStream outStream = response.getOutputStream();
			outStream.write(outArray);
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void downloadContactsExcel(HttpServletResponse response,
			List<ContactPerson> contactPersons) {

		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFCellStyle style = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.WHITE.index);
		font.setFontName(HSSFFont.FONT_ARIAL);
		style.setFont(font);
		style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setWrapText(true);

		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setWrapText(true);
		style1.setAlignment(CellStyle.ALIGN_LEFT);
		HSSFSheet sheet = wb.createSheet();
		sheet.setColumnWidth(0, 1700);
		sheet.setColumnWidth(1, 6000);
		sheet.setColumnWidth(2, 6000);
		sheet.setColumnWidth(3, 6000);

		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(25f);
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("S.No.");
		cell = row.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("Contact Person");
		cell = row.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("Contact No");
		cell = row.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("Alternate Contact No");

		int rows = 1;
		int i = 0;

		for (ContactPerson contactPerson : contactPersons) {
			i++;
			row = sheet.createRow(rows);
			cell = row.createCell(0);
			cell.setCellStyle(style1);
			cell.setCellValue(i);
			cell = row.createCell(1);
			cell.setCellStyle(style1);
			cell.setCellValue(contactPerson.getName());
			cell = row.createCell(2);
			cell.setCellStyle(style1);
			cell.setCellValue(contactPerson.getContactNo());
			cell = row.createCell(3);
			cell.setCellStyle(style1);
			cell.setCellValue(contactPerson.getAlternateNo());
			rows++;
		}

		// write it as an excel attachment
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		try {
			wb.write(outByteStream);
			byte[] outArray = outByteStream.toByteArray();
			response.setContentType("application/ms-excel");
			response.setContentLength(outArray.length);
			response.setHeader("Expires:", "0"); // eliminates browser caching
			response.setHeader("Content-Disposition",
					"attachment; filename=Contacts.xls");
			OutputStream outStream = response.getOutputStream();
			outStream.write(outArray);
			outStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

	}

}
