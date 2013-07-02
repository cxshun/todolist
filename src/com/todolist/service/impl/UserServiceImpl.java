package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.UserDao;
import com.todolist.domain.TodoItem;
import com.todolist.domain.User;
import com.todolist.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public boolean add(User user) {
		return userDao.add(user);
	}

	public boolean update(User user) {
		return userDao.update(user);
	}

	public boolean delete(int id) {
		return userDao.delete(id);
	}

	public User get(int id) {
		return userDao.get(id);
	}
	
	public User getByLoginId(String loginId) {
		return userDao.getByLoginId(loginId);
	}

	public List<User> getList() {
		return userDao.getList();
	}

	public List<TodoItem> getToDoItemListById(int id) {
		return userDao.getToDoItemListById(id);
	}

}
