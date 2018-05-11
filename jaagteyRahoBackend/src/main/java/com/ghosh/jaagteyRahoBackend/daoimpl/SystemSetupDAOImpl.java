package com.ghosh.jaagteyRahoBackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;
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

}
