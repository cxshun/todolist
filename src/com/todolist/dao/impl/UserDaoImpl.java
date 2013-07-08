package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todolist.dao.UserDao;
import com.todolist.domain.TodoItem;
import com.todolist.domain.User;

@Repository
public class UserDaoImpl implements UserDao{

	private Session session;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}
	
	public boolean add(User user) {
		try {
			session.save(user);
		} catch(Exception e) {
			return false;
		} 
		return true;
	}

	public boolean update(User user) {
		try {
			session.update(user);
		} catch(Exception e) {
			return false;
		} 
		return true;
	}

	public boolean delete(int id) {
		try {
			session.delete(get(id));
		} catch(Exception e) {
			return false;
		} 
		return true;
	}

	public User get(int id) {
		return (User)session.get(User.class, id);
	}
	
	public User getByLoginId(String loginId) {
		Query query = session.createQuery("from User u where u.loginId = ?");
		query.setString(1, loginId);
		return (User)query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	public List<TodoItem> getToDoItemListById(int id) {
		Query query = session
				.createQuery("from User u,TodoItem t where t.user = u.id");
		return (List<TodoItem>)query.list();
	}

	@SuppressWarnings("unchecked")
	public List<User> getList() {
		Query query = session.createQuery("from User");
		return (List<User>)query.list();
	}

}
