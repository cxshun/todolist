package com.todolist.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.constant.DateType;
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

	public List<TodoItem> getListByDate(String dateType) {
		Calendar cal = Calendar.getInstance();
		//get todolist in the last three days
		if (dateType.equals(DateType.THREE_DAY)){
			cal.add(Calendar.DAY_OF_MONTH, -DateType.THREE_DAY_INT);
		} 
		//get todolist int the last month
		else if (dateType.equals(DateType.AMONTH)){
			cal.add(Calendar.MONTH, -DateType.AMONTH_INT);
		} 
		//get todolist in the last three month
		else if (dateType.equals(DateType.THREE_MONTH)){
			cal.add(Calendar.MONDAY, -DateType.THREE_MONTH_INT);
		} 
		//get todolist in the last week
		else if (dateType.equals(DateType.AWEEK)){
			cal.add(Calendar.DAY_OF_MONTH, -DateType.AWEEK_INT);
		}
		return todoItemDao.getListByDate(cal.getTime());
	}

}
