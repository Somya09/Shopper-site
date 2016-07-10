package com.niit.shopperssite.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopperssite.model.User;
import com.niit.shopperssite.model.UserDetails;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) sessionFactory.openSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.openSession().saveOrUpdate(user);
	}
	
	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {
		sessionFactory.openSession().saveOrUpdate(userDetails);
	}


	@Transactional
	public void delete(String id) {
		User user = new User();
		user.setId(id);
		sessionFactory.openSession().delete(user);
	}

	@Transactional
	public User get(String id) {
		String hql = "from User where id=" + id;
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}
	@Transactional
	public User getByName(String name) {
		String hql = "from User where name=" +name;
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}
	
	@Transactional
	public boolean isValidUser(String id, String password, boolean isAdmin) {
		String hql = "from User where id= '" + id + "' and " + " password ='" + password+"'";
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}
}
