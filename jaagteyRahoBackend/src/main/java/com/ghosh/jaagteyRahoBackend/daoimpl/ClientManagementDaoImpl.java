package com.ghosh.jaagteyRahoBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ghosh.jaagteyRahoBackend.dao.ClientManagementDao;
import com.ghosh.jaagteyRahoBackend.dto.Client;
import com.ghosh.jaagteyRahoBackend.dto.Site;

@Repository("clientManagementDao")
@Transactional
public class ClientManagementDaoImpl implements ClientManagementDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Client> getAllClients() {
		String selectQuery = "FROM Client";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, Client.class).getResultList();
	}

	@Override
	public boolean saveOrUpdateClient(Client client) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(client);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Client getClientById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Client.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean deleteClient(Client client) {
		try {
			sessionFactory.getCurrentSession().delete(client);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public List<Site> getAllSites() {
		String selectQuery = "FROM Site";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, Site.class).getResultList();
	}

	@Override
	public boolean saveOrUpdateSite(Site site) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(site);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Site getSiteById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Site.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
