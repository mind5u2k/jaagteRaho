package com.ghosh.jaagteyRaho.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.ghosh.jaagteyRaho.model.EmployeeSiteCsvModel;
import com.ghosh.jaagteyRaho.model.SiteEmpReport;
import com.ghosh.jaagteyRaho.service.PdfGeneration.PdfGeneration;
import com.ghosh.jaagteyRaho.service.excelServices.DownloadExcel;
import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.ClientManagementDao;
import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.Client;
import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;
import com.ghosh.jaagteyRahoBackend.dto.Designation;
import com.ghosh.jaagteyRahoBackend.dto.PushNotificationsStatus;
import com.ghosh.jaagteyRahoBackend.dto.Site;
import com.ghosh.jaagteyRahoBackend.dto.SiteEmployeeMapping;
import com.ghosh.jaagteyRahoBackend.dto.User;
import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/admin")
public class FileDownloadController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ClientManagementDao clientManagementDao;

	@Autowired
	private SystemSetupDAO systemSetupDAO;

	@RequestMapping(value = "/downloadReports")
	public void downloadReports(
			@RequestParam(name = "clientid", required = false) Integer clientid,
			@RequestParam(name = "siteId", required = false) Integer siteId,
			@RequestParam(name = "empId", required = false) Integer empId,
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate,
			HttpServletResponse response) throws IOException {

		System.out.println("selected emp Id is[" + empId
				+ "] and selected start date is [" + startDate + "]");

		List<User> users = new ArrayList<User>();
		if (clientid == 0) {
			users = userDAO.getAllUsersByRole(Util.ROLE_USER);
		} else {
			if (siteId == 0) {
				Client client = clientManagementDao.getClientById(clientid);
				List<Site> sites = clientManagementDao.getSitesByClient(client);

				for (Site s : sites) {
					List<SiteEmployeeMapping> mappings = clientManagementDao
							.assignedEmployeestoSite(s);
					if (mappings != null) {
						for (SiteEmployeeMapping sem : mappings) {
							users.add(sem.getEmployee());
						}
					}
				}
			} else {
				if (empId == 0) {
					Site site = clientManagementDao.getSiteById(siteId);
					List<SiteEmployeeMapping> mappings = clientManagementDao
							.assignedEmployeestoSite(site);
					if (mappings != null) {
						for (SiteEmployeeMapping sem : mappings) {
							users.add(sem.getEmployee());
						}
					}

				} else {
					User u = userDAO.get(empId);
					users.add(u);
				}
			}

		}

		String[] startDateArray = startDate.split("/");
		int td = Integer.parseInt(startDateArray[0]);
		int tm = Integer.parseInt(startDateArray[1]);
		int ty = Integer.parseInt(startDateArray[2]);

		String[] endDateArray = endDate.split("/");
		int tdend = Integer.parseInt(endDateArray[0]);
		int tmend = Integer.parseInt(endDateArray[1]);
		int tyend = Integer.parseInt(endDateArray[2]);

		List<PushNotificationsStatus> pushNotificationsStatus = new ArrayList<PushNotificationsStatus>();

		for (User emp : users) {
			if (emp != null) {
				List<PushNotificationsStatus> pushNotificationsStatuss = systemSetupDAO
						.getPushNotificationsByEmployee(emp);
				if (pushNotificationsStatuss != null) {
					for (PushNotificationsStatus s : pushNotificationsStatuss) {
						Timestamp ts = s.getSentTimestamp();
						Date ds = new Date(ts.getTime());
						Calendar cal = Calendar.getInstance();
						cal.setTimeInMillis(ds.getTime());
						int d = cal.get(Calendar.DATE);
						int m = cal.get(Calendar.MONTH);
						int y = cal.get(Calendar.YEAR);

						if (d >= td && m >= (tm - 1) && y >= ty && d <= tdend
								&& m <= (tmend - 1) && y <= tyend) {
							if (s.getSentStatus() != null) {
								if (s.getSentStatus().equals(Util.SUCCESS)) {
								}
							}

							if (s.getReceivedStatus() != null) {
								if (s.getReceivedStatus().equals(Util.SUCCESS)) {
								}
							}
							pushNotificationsStatus.add(s);
						}
					}
				}
			}
		}
		Collections.reverse(pushNotificationsStatus);
		DownloadExcel.downloadExcelReport(response, pushNotificationsStatus);
	}

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

	@RequestMapping(value = "/downloadExcelEmployeeSite")
	public void downloadExcelEmployeeSite(HttpServletResponse response)
			throws IOException {

		List<Site> sites = clientManagementDao.getAllSites();
		List<SiteEmpReport> reports = new ArrayList<SiteEmpReport>();
		for (Site site : sites) {
			SiteEmpReport report = new SiteEmpReport();
			report.setSite(site);
			report.setMappings(clientManagementDao
					.assignedEmployeestoSite(site));
			reports.add(report);
		}
		DownloadExcel.downloadEmployeeSiteExcel(response, reports);
	}

	@RequestMapping(value = "/downloadPdfEmployeeSite")
	public void downloadPdfEmployeeSite(HttpServletResponse response)
			throws IOException {
		List<Site> sites = clientManagementDao.getAllSites();
		List<SiteEmpReport> reports = new ArrayList<SiteEmpReport>();
		for (Site site : sites) {
			SiteEmpReport report = new SiteEmpReport();
			report.setSite(site);
			report.setMappings(clientManagementDao
					.assignedEmployeestoSite(site));
			reports.add(report);
		}
		try {
			PdfGeneration.generateEmployeeSitePdf(response, reports);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/downloadCSVEmployeeSite")
	public void downloadCSVEmployeeSite(HttpServletResponse response)
			throws IOException {
		String csvFileName = "EmployeeSiteReport.csv";
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);
		String[] header = { "clientCode", "clientName", "siteCode", "siteName",
				"siteAddress", "AssignedEmployees" };
		csvWriter.writeHeader(header);
		CellProcessor[] processors = new CellProcessor[] { new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional() };

		List<Site> sites = clientManagementDao.getAllSites();
		List<SiteEmpReport> reports = new ArrayList<SiteEmpReport>();
		List<EmployeeSiteCsvModel> csvReports = new ArrayList<EmployeeSiteCsvModel>();
		for (Site site : sites) {
			SiteEmpReport report = new SiteEmpReport();
			report.setSite(site);
			report.setMappings(clientManagementDao
					.assignedEmployeestoSite(site));
			reports.add(report);
			EmployeeSiteCsvModel csvModel = new EmployeeSiteCsvModel();
			csvModel.setClientCode(report.getSite().getClient().getClientCode());
			csvModel.setClientName(report.getSite().getClient().getClientName());
			csvModel.setSiteCode(report.getSite().getSiteCode());
			csvModel.setSiteName(report.getSite().getSiteName());
			csvModel.setSiteAddress(report.getSite().getAddress());
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
			csvModel.setAssignedEmployees(employees);
			csvReports.add(csvModel);
		}
		for (EmployeeSiteCsvModel u : csvReports) {
			csvWriter.write(u, header, processors);
		}
		csvWriter.close();
	}

	@RequestMapping(value = "/downloadExcelDesignations")
	public void downloadExcelDesignations(HttpServletResponse response)
			throws IOException {
		List<Designation> designations = userDAO.getAllDesignations();
		DownloadExcel.downloadDesignationsExcel(response, designations);
	}

	@RequestMapping(value = "/downloadPdfDesignations")
	public void downloadPdfDesignations(HttpServletResponse response)
			throws IOException {
		List<Designation> designations = userDAO.getAllDesignations();
		try {
			PdfGeneration.generateDesignationsPdf(response, designations);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/downloadCSVDesignations")
	public void downloadCSVDesignations(HttpServletResponse response)
			throws IOException {
		String csvFileName = "Designations.csv";
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);
		String[] header = { "designationCode", "designationName" };
		csvWriter.writeHeader(header);
		CellProcessor[] processors = new CellProcessor[] { new Optional(),
				new Optional() };
		List<Designation> designations = userDAO.getAllDesignations();
		for (Designation u : designations) {
			csvWriter.write(u, header, processors);
		}
		csvWriter.close();
	}

	@RequestMapping(value = "/downloadExcelContacts")
	public void downloadExcelContacts(HttpServletResponse response)
			throws IOException {
		List<ContactPerson> contactPersons = systemSetupDAO
				.getAllContactPersons();
		DownloadExcel.downloadContactsExcel(response, contactPersons);
	}

	@RequestMapping(value = "/downloadPdfContacts")
	public void downloadPdfContacts(HttpServletResponse response)
			throws IOException {
		List<ContactPerson> contactPersons = systemSetupDAO
				.getAllContactPersons();
		try {
			PdfGeneration.generateContactsPdf(response, contactPersons);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/downloadCSVContacts")
	public void downloadCSVContacts(HttpServletResponse response)
			throws IOException {
		String csvFileName = "Contacts.csv";
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);
		String[] header = { "name", "contactNo", "alternateNo" };
		csvWriter.writeHeader(header);
		CellProcessor[] processors = new CellProcessor[] { new Optional(),
				new Optional(), new Optional() };
		List<ContactPerson> contactPersons = systemSetupDAO
				.getAllContactPersons();
		for (ContactPerson u : contactPersons) {
			csvWriter.write(u, header, processors);
		}
		csvWriter.close();
	}

}