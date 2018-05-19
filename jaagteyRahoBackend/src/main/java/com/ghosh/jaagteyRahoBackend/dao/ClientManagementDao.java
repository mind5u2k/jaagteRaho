package com.ghosh.jaagteyRahoBackend.dao;

import java.util.List;

import com.ghosh.jaagteyRahoBackend.dto.Client;
import com.ghosh.jaagteyRahoBackend.dto.Site;

public interface ClientManagementDao {

	List<Client> getAllClients();

	boolean saveOrUpdateClient(Client client);

	Client getClientById(int id);

	boolean deleteClient(Client client);

	List<Site> getAllSites();

	boolean saveOrUpdateSite(Site site);

	Site getSiteById(int id);

}
