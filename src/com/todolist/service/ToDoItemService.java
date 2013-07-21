package com.todolist.service;

import java.util.List;

import com.todolist.domain.TodoItem;

public interface ToDoItemService {

	public boolean add(TodoItem todoItem);
	
	public boolean update(TodoItem todoItem);
	
	public boolean delete(int id);
	
	public TodoItem get(int id);
	
	public List<TodoItem> getList();
	
	public List<TodoItem> getByCategory(int categoryId);
	
	/**
	 * @param dateType 日期类型，一周内，一月内，三月内
	 * @return
	 */
	public List<TodoItem> getListByDate(String dateType);
}
