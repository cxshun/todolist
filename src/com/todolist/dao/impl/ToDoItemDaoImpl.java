package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todolist.constant.Constants;
import com.todolist.dao.ToDoItemDao;
import com.todolist.domain.PageBean;
import com.todolist.domain.TodoItem;

@Repository
public class ToDoItemDaoImpl implements ToDoItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean add(TodoItem todoItem) {
		try{
			sessionFactory.getCurrentSession().save(todoItem);
		} catch (Exception e){
			e.printStackTrace();
			return false;
		} 
		return true;
	}

	public boolean update(TodoItem todoItem) {
		try{
			sessionFactory.getCurrentSession().update(todoItem);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}

	public TodoItem get(int id) {
		return (TodoItem)sessionFactory.getCurrentSession().get(TodoItem.class, id);
	}
	
	public TodoItem getLastest(int userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from TodoItem t where t.user = ? " +
				"order by t.createDate desc");
		query.setInteger(0, userId);
		query.setFirstResult(0);
		query.setMaxResults(1);
		if (query.list().size() > 0) {
			return (TodoItem)query.list().get(0);
		}
		return new TodoItem();
	}

	@SuppressWarnings("unchecked")
	public List<TodoItem> getList(int userId,boolean isFinished,PageBean pageBean) {
		Query query = sessionFactory.getCurrentSession().createQuery("from TodoItem t where t.user = ? " +
				"and t.isFinished = ? order by t.createDate desc");
		query.setInteger(0, userId);
		query.setBoolean(1, isFinished);
		
		query.setFirstResult(pageBean.getStartIndex());
		query.setMaxResults((pageBean.getEndIndex() == 0) ? pageBean.getStartIndex() + Constants.PAGE_SIZE : pageBean.getEndIndex());
		return query.list();
	}

	public boolean delete(int id) {
		try{
			sessionFactory.getCurrentSession().delete(get(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
