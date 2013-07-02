package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todolist.dao.ToDoItemDao;
import com.todolist.domain.TodoItem;

@Repository
public class ToDoItemDaoImpl implements ToDoItemDao {

	private Session session;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}
	
	public boolean add(TodoItem todoItem) {
		try{
			session.save(todoItem);
		} catch (Exception e){
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean update(TodoItem todoItem) {
		try{
			session.update(todoItem);
		} catch(Exception e) {
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean delete(int id) {
		try{
			session.delete(get(id));
		} catch(Exception e) {
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public TodoItem get(int id) {
		try {
			return (TodoItem)session.get(TodoItem.class, id);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TodoItem> getList() {
		try {
			Query query = session.createQuery("from TodoItem t");
			return (List<TodoItem>)query.list();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TodoItem> getByCategory(int categoryId) {
		try {
			Query query = session.createQuery("from TodoItem t where t.category = ?");
			query.setInteger(1, categoryId);
			return query.list();
		} finally {
			session.close();
		}
	}

}
