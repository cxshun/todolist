package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todolist.dao.CategoryDao;
import com.todolist.domain.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private Session session;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}
	
	public boolean add(Category category) {
		try{
			session.save(category);
		} catch(Exception e) {
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean update(Category category) {
		try {
			session.update(category);
		} catch(Exception e){
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean delete(int id) {
		try{
			session.delete(get(id));
		} catch(Exception e){
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public Category get(int id) {
		try {
			return (Category)session.get(Category.class, id);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Category> getList() {
		try {
			Query query = session.createQuery("from Category c");
			return (List<Category>)query.list();
		} finally {
			session.close();
		}
	}

	public Category getByToDoItem(int todoItemId) {
		try {
			Query query = session.createQuery("from Category c where c.todoItem = ?");
			query.setInteger(1, todoItemId);
			return (Category)query.list().get(0);
		} finally {
			session.close();
		}
	}

}
