package com.ghosh.jaagteyRahoBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.ClientManagementDao;
import com.ghosh.jaagteyRahoBackend.dto.Client;
import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;
import com.ghosh.jaagteyRahoBackend.dto.Site;
import com.ghosh.jaagteyRahoBackend.dto.SiteContactMapping;
import com.ghosh.jaagteyRahoBackend.dto.SiteEmployeeMapping;
import com.ghosh.jaagteyRahoBackend.dto.User;

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

	@Override
	public List<SiteEmployeeMapping> assignedEmployeestoSite(Site site) {
		String selectQuery = "FROM SiteEmployeeMapping WHERE site.id = :id ORDER BY id DESC";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, SiteEmployeeMapping.class)
				.setParameter("id", site.getId()).getResultList();

	}

	@Override
	public SiteEmployeeMapping getSiteEmpMappingById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(
					SiteEmployeeMapping.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public SiteEmployeeMapping getSiteEmpMappingByEmpAndSite(Site site, User emp) {
		String selectQuery = "FROM SiteEmployeeMapping WHERE site.id = :siteId AND employee.id = :empId ORDER BY id DESC";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, SiteEmployeeMapping.class)
				.setParameter("siteId", site.getId())
				.setParameter("empId", emp.getId()).getSingleResult();

	}

	@Override
	public List<User> getUnAssignedEmployees(Site site) {
		String selectQuery = "FROM User WHERE id not in (select employee.id from SiteEmployeeMapping WHERE site.id = :siteId) AND role = :role ORDER BY id DESC";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, User.class)
				.setParameter("siteId", site.getId())
				.setParameter("role", Util.ROLE_USER).getResultList();

	}

	@Override
	public boolean saveOrUpdateSiteEmployeeMapping(SiteEmployeeMapping mapping) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(mapping);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteSiteEmpMapping(SiteEmployeeMapping mapping) {
		try {
			sessionFactory.getCurrentSession().delete(mapping);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public List<SiteContactMapping> assignedContactstoSite(Site site) {
		String selectQuery = "FROM SiteContactMapping WHERE site.id = :id ORDER BY id DESC";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, SiteContactMapping.class)
				.setParameter("id", site.getId()).getResultList();

	}

	@Override
	public List<ContactPerson> getUnAssignedContacts(Site site) {
		String selectQuery = "FROM ContactPerson WHERE id not in (select contactPerson.id from SiteContactMapping WHERE site.id = :siteId) ORDER BY id DESC";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, ContactPerson.class)
				.setParameter("siteId", site.getId()).getResultList();

	}

	@Override
	public boolean saveOrUpdateSiteContactMapping(SiteContactMapping mapping) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(mapping);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public SiteContactMapping getContactMappingById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(
					SiteContactMapping.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean deleteSiteContactMapping(SiteContactMapping mapping) {
		try {
			sessionFactory.getCurrentSession().delete(mapping);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
