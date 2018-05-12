package com.ghosh.jaagteyRahoBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;
import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;

@Repository("systemSetupDAO")
@Transactional
public class SystemSetupDAOImpl implements SystemSetupDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AutoCheckinSetting getAutoCheckinSetting() {
		String selectQuery = "FROM AutoCheckinSetting";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, AutoCheckinSetting.class)
					.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public boolean updateAutoCheckinSetting(
			AutoCheckinSetting autoCheckinSetting) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(autoCheckinSetting);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public List<ContactPerson> getAllContactPersons() {
		String selectQuery = "FROM ContactPerson";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, ContactPerson.class).getResultList();
	}

	@Override
	public boolean addUpdatedContactPerson(ContactPerson contactPerson) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(contactPerson);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public ContactPerson getContactPersonById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(ContactPerson.class,
					id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean deleteContactPerson(ContactPerson contactPerson) {
		try {
			sessionFactory.getCurrentSession().delete(contactPerson);
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

}
