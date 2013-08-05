package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todolist.dao.UserDao;
import com.todolist.domain.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean add(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}

	public boolean delete(int id) {
		try {
			sessionFactory.getCurrentSession().delete(get(id));
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}

	public User get(int id) {
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	public User getByUserId(String userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.userId = ?");
		query.setString(0, userId);
		if (query.list().size() > 0) {
			return (User)query.list().get(0);
		} 
		return new User();
	}

	@SuppressWarnings("unchecked")
	public List<User> getList() {
		Query query = sessionFactory.getCurrentSession().createQuery("from User");
		return (List<User>)query.list();
	}

}
