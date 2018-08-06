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
import com.ghosh.jaagteyRahoBackend.dto.Site;
import com.ghosh.jaagteyRahoBackend.dto.User;

@Repository("systemSetupDAO")
@Transactional
public class SystemSetupDAOImpl implements SystemSetupDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<AutoCheckinSetting> getAutoCheckinSetting() {
		String selectQuery = "FROM AutoCheckinSetting ORDER BY employee.id";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, AutoCheckinSetting.class)
					.getResultList();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public AutoCheckinSetting getAutoCheckinSettingByUser(int userId) {
		String selectQuery = "FROM AutoCheckinSetting WHERE employee.id=:empId";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, AutoCheckinSetting.class)
					.setParameter("empId", userId).getSingleResult();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public AutoCheckinSetting getAutoCheckinSettingById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(
					AutoCheckinSetting.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public boolean deleteAutoCheckinSetting(
			AutoCheckinSetting autoCheckinSetting) {
		try {

			sessionFactory.getCurrentSession().delete(autoCheckinSetting);
			return true;

		} catch (Exception ex) {
			System.out.println("===============hello there");
			return false;
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
				.setParameter("latestStatus", 1).getResultList();
	}

	@Override
	public List<PushNotificationsStatus> getPushNotificationsByEmployee(User emp) {
		String selectQuery = "FROM PushNotificationsStatus WHERE employee.id=:empId";
		try {
			List<PushNotificationsStatus> a = sessionFactory
					.getCurrentSession()
					.createQuery(selectQuery, PushNotificationsStatus.class)
					.setParameter("empId", emp.getId()).getResultList();
			if (a != null) {
				if (a.size() > 0) {
					return a;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public PushNotificationsStatus getLatestPushNotificationByUser(User user,
			String type) {
		String selectQuery = "FROM PushNotificationsStatus WHERE employee.id=:empId AND latestStatus=:latestStatus AND sentBy=:sentBy";

		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, PushNotificationsStatus.class)
					.setParameter("empId", user.getId())
					.setParameter("latestStatus", 1)
					.setParameter("sentBy", type).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public void updateAllNotifications(User user) {
		String selectQuery = "UPDATE PushNotificationsStatus SET latestStatus=0 WHERE employee.id=:empId AND latestStatus=:latestStatus";

		try {
			sessionFactory.getCurrentSession().createQuery(selectQuery)
					.setParameter("empId", user.getId())
					.setParameter("latestStatus", 1).executeUpdate();
		} catch (Exception e) {
		}

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
