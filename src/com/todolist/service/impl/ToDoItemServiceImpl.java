package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.ToDoItemDao;
import com.todolist.dao.UserDao;
import com.todolist.domain.PageBean;
import com.todolist.domain.TodoItem;
import com.todolist.service.TodoItemService;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class TodoItemServiceImpl implements TodoItemService{

	@Autowired
	private ToDoItemDao todoItemDao;
	
	@Autowired
	private UserDao userDao;
	
	public boolean add(TodoItem todoItem) {
		return todoItemDao.add(todoItem);
	}

	public boolean update(TodoItem todoItem) {
		return todoItemDao.update(todoItem);
	}

	public TodoItem get(int id) {
		return todoItemDao.get(id);
	}
	
	public TodoItem getLastest(String userId) {
		return todoItemDao.getLastest(userDao.getByUserId(userId).getId());
	}

	public List<TodoItem> getList(String userId,boolean isFinished,PageBean pageBean) {
		return todoItemDao.getList(userDao.getByUserId(userId).getId(),isFinished,pageBean);
	}

	public boolean delete(int id) {
		return todoItemDao.delete(id);
	}

}
