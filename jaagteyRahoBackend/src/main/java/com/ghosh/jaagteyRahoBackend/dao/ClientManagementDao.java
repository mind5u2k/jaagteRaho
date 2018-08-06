package com.ghosh.jaagteyRahoBackend.dao;

import java.util.List;

import com.ghosh.jaagteyRahoBackend.dto.Client;
import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;
import com.ghosh.jaagteyRahoBackend.dto.Site;
import com.ghosh.jaagteyRahoBackend.dto.SiteContactMapping;
import com.ghosh.jaagteyRahoBackend.dto.SiteEmployeeMapping;
import com.ghosh.jaagteyRahoBackend.dto.User;

public interface ClientManagementDao {

	List<Client> getAllClients();

	boolean saveOrUpdateClient(Client client);

	Client getClientById(int id);

	boolean deleteClient(Client client);

	boolean deleteSite(Site site);

	List<Site> getAllSites();

	List<Site> getSitesByClient(Client client);

	boolean saveOrUpdateSite(Site site);

	Site saveSite(Site site);

	Site getSiteById(int id);

	List<SiteEmployeeMapping> assignedEmployeestoSite(Site site);

	List<SiteEmployeeMapping> assignedSiteToEmployee(User user);

	SiteEmployeeMapping getSiteEmpMappingByEmpAndSite(Site site, User emp);

	SiteEmployeeMapping getSiteEmpMappingById(int id);

	List<SiteEmployeeMapping> getSiteEmpMappingByUserId(int userId);

	List<User> getUnAssignedEmployees(Site site);

	boolean saveOrUpdateSiteEmployeeMapping(SiteEmployeeMapping mapping);

	boolean deleteSiteEmpMapping(SiteEmployeeMapping mapping);

	List<SiteContactMapping> assignedContactstoSite(Site site);

	List<ContactPerson> getUnAssignedContacts(Site site);

	boolean saveOrUpdateSiteContactMapping(SiteContactMapping mapping);

	SiteContactMapping getContactMappingById(int id);

	boolean deleteSiteContactMapping(SiteContactMapping mapping);
}
