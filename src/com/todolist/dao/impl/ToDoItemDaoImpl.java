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
		} 
		return true;
	}

	public boolean update(TodoItem todoItem) {
		try{
			session.update(todoItem);
		} catch(Exception e) {
			return false;
		} 
		return true;
	}

	public TodoItem get(int id) {
		return (TodoItem)session.get(TodoItem.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<TodoItem> getList() {
		Query query = session.createQuery("from TodoItem t");
		return (List<TodoItem>)query.list();
	}

	@SuppressWarnings("unchecked")
	public List<TodoItem> getList(int userId) {
		Query query = session.createQuery("from TodoItem t where t.user = ?");
		query.setInteger(0, userId);
		return query.list();
	}

}
