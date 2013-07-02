package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.CategoryDao;
import com.todolist.domain.Category;
import com.todolist.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public boolean add(Category category) {
		return categoryDao.add(category);
	}

	public boolean update(Category category) {
		return categoryDao.update(category);
	}

	public boolean delete(int id) {
		return categoryDao.delete(id);
	}

	public Category get(int id) {
		return categoryDao.get(id);
	}

	public List<Category> getList() {
		return categoryDao.getList();
	}

	public Category getByToDoItem(int todoItemId) {
		return categoryDao.getByToDoItem(todoItemId);
	}

}
