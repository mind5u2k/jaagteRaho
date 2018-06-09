package com.ghosh.jaagteyRahoBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;
import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;
import com.ghosh.jaagteyRahoBackend.dto.PushNotificationsStatus;
import com.ghosh.jaagteyRahoBackend.dto.User;

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

	@Override
	public boolean addPustNotificationStatus(PushNotificationsStatus status) {
		try {
			sessionFactory.getCurrentSession().persist(status);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public List<PushNotificationsStatus> getLatestPushNotifications() {
		String selectQuery = "FROM PushNotificationsStatus WHERE latestStatus=:latestStatus";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, PushNotificationsStatus.class)
				.setParameter("latestStatus", true).getResultList();
	}

	@Override
	public List<PushNotificationsStatus> getPushNotificationsByEmployee(User emp) {
		String selectQuery = "FROM PushNotificationsStatus WHERE employee.id=:empId";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, PushNotificationsStatus.class)
				.setParameter("empId", emp.getId()).getResultList();
	}

	@Override
	public PushNotificationsStatus getLatestPushNotificationByUser(User user) {
		String selectQuery = "FROM PushNotificationsStatus WHERE employee.id=:empId AND latestStatus=:latestStatus";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, PushNotificationsStatus.class)
				.setParameter("empId", user.getId())
				.setParameter("latestStatus", true).getSingleResult();
	}

	@Override
	public boolean UpdatePustNotificationStatus(PushNotificationsStatus status) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(status);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
