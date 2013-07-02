package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.ToDoItemDao;
import com.todolist.domain.TodoItem;
import com.todolist.service.ToDoItemService;

@Service
public class ToDoItemServiceImpl implements ToDoItemService{

	@Autowired
	private ToDoItemDao todoItemDao;
	
	public boolean add(TodoItem todoItem) {
		return todoItemDao.add(todoItem);
	}

	public boolean update(TodoItem todoItem) {
		return todoItemDao.update(todoItem);
	}

	public boolean delete(int id) {
		return todoItemDao.delete(id);
	}

	public TodoItem get(int id) {
		return todoItemDao.get(id);
	}

	public List<TodoItem> getList() {
		return todoItemDao.getList();
	}

	public List<TodoItem> getByCategory(int categoryId) {
		return todoItemDao.getByCategory(categoryId);
	}

}
