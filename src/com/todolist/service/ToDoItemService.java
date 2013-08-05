package com.todolist.service;

import java.util.List;

import com.todolist.domain.PageBean;
import com.todolist.domain.TodoItem;

public interface TodoItemService {

	public boolean add(TodoItem todoItem);
	
	public boolean update(TodoItem todoItem);
	
	public boolean delete(int id);
	
	public TodoItem get(int id);
	
	public TodoItem getLastest(String userId);
	
	public List<TodoItem> getList(String userId,boolean isFinished,PageBean pageBean);
	
}
