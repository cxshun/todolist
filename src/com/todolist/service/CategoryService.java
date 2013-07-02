package com.todolist.service;

import java.util.List;

import com.todolist.domain.Category;

public interface CategoryService {

	public boolean add(Category category);
	
	public boolean update(Category category);
	
	public boolean delete(int id);
	
	public Category get(int id);
	
	public List<Category> getList();
	
	public Category getByToDoItem(int todoItemId);
	
}
