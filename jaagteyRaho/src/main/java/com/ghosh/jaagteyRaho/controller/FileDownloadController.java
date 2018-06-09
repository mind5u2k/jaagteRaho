package com.ghosh.jaagteyRaho.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.ghosh.jaagteyRaho.service.PdfGeneration.PdfGeneration;
import com.ghosh.jaagteyRaho.service.excelServices.DownloadExcel;
import com.ghosh.jaagteyRahoBackend.dao.ClientManagementDao;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.Client;
import com.ghosh.jaagteyRahoBackend.dto.Site;
import com.ghosh.jaagteyRahoBackend.dto.User;
import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/admin")
public class FileDownloadController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ClientManagementDao clientManagementDao;

	@RequestMapping(value = "/downloadExcelEmp")
	public void downloadExcelEmp(HttpServletResponse response)
			throws IOException {
		List<User> employees = userDAO.getAllUsers();
		DownloadExcel.downloadEmployeeExcel(response, employees);
	}

	@RequestMapping(value = "/downloadPdfEmp")
	public void downloadPdfEmp(HttpServletResponse response) throws IOException {
		List<User> employees = userDAO.getAllUsers();
		try {
			PdfGeneration.generateEmpPdf(response, employees);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/downloadCSV")
	public void downloadCSV(HttpServletResponse response) throws IOException {
		String csvFileName = "Employee.csv";
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);
		String[] header = { "empId", "firstName", "middleName", "lastName",
				"email", "dob", "contactNumber", "alternateNumber", "role",
				"gender", "designationName", "corredpondenceAddress",
				"corredpondencePostalCode", "corredpondenceState",
				"corredpondenceCity", "permanentAddress",
				"permanentPostalCode", "permanentState", "permanentCity" };
		csvWriter.writeHeader(header);
		CellProcessor[] processors = new CellProcessor[] { new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional() };
		List<User> users = userDAO.getAllUsers();
		for (User u : users) {
			csvWriter.write(u, header, processors);
		}
		csvWriter.close();
	}

	@RequestMapping(value = "/downloadExcelClient")
	public void downloadExcelClient(HttpServletResponse response)
			throws IOException {
		List<Client> clients = clientManagementDao.getAllClients();
		DownloadExcel.downloadClientExcel(response, clients);
	}

	@RequestMapping(value = "/downloadPdfClient")
	public void downloadPdfClient(HttpServletResponse response)
			throws IOException {
		List<Client> clients = clientManagementDao.getAllClients();
		try {
			PdfGeneration.generateEmpClient(response, clients);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/downloadCSVClients")
	public void downloadCSVClients(HttpServletResponse response)
			throws IOException {
		String csvFileName = "Clients.csv";
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);
		String[] header = { "clientCode", "clientName", "contactPerson",
				"contactNo", "emailId", "address" };
		csvWriter.writeHeader(header);
		CellProcessor[] processors = new CellProcessor[] { new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional() };
		List<Client> clients = clientManagementDao.getAllClients();
		for (Client u : clients) {
			csvWriter.write(u, header, processors);
		}
		csvWriter.close();
	}

	@RequestMapping(value = "/downloadExcelSite")
	public void downloadExcelSite(HttpServletResponse response)
			throws IOException {
		List<Site> sites = clientManagementDao.getAllSites();
		DownloadExcel.downloadSiteExcel(response, sites);
	}

	@RequestMapping(value = "/downloadPdfSite")
	public void downloadPdfSite(HttpServletResponse response)
			throws IOException {
		List<Site> sites = clientManagementDao.getAllSites();
		try {
			PdfGeneration.generateSitePdf(response, sites);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/downloadCSVSite")
	public void downloadCSVSite(HttpServletResponse response)
			throws IOException {
		String csvFileName = "Sites.csv";
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);
		String[] header = { "siteCode", "siteName", "clientName",
				"contactPerson", "contactNo", "emailId", "address" };
		csvWriter.writeHeader(header);
		CellProcessor[] processors = new CellProcessor[] { new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional() };
		List<Site> sites = clientManagementDao.getAllSites();
		for (Site u : sites) {
			csvWriter.write(u, header, processors);
		}
		csvWriter.close();
	}

}