package com.ghosh.jaagteyRahoBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.Address;
import com.ghosh.jaagteyRahoBackend.dto.Designation;
import com.ghosh.jaagteyRahoBackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, User.class)
					.setParameter("email", email).getSingleResult();
		} catch (Exception ex) {
			return null;
		}

	}

	@Override
	public User getUserByMobileNo(String contactNumber) {
		String selectQuery = "FROM User WHERE contactNumber = :contactNumber";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, User.class)
					.setParameter("contactNumber", contactNumber)
					.getSingleResult();
		} catch (Exception ex) {
			return null;
		}

	}

	@Override
	public boolean add(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public User addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return user;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			// will look for this code later and why we need to change it
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Address getAddressByUser(int userId) {
		String selectQuery = "FROM Address WHERE user.id = :userId";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("userId", userId).getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public User get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(User.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public Address getAddress(int addressId) {
		try {
			return sessionFactory.getCurrentSession().get(Address.class,
					addressId);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() {
		String selectQuery = "FROM User";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, User.class).getResultList();
	}

	@Override
	public List<User> getAllUsersByRole(String role) {
		String selectQuery = "FROM User WHERE role = :role";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, User.class)
				.setParameter("role", role).getResultList();
	}

	@Override
	public List<Designation> getAllDesignations() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Designation", Designation.class)
				.getResultList();
	}

	@Override
	public boolean addDesignation(Designation designation) {
		try {
			sessionFactory.getCurrentSession().persist(designation);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
