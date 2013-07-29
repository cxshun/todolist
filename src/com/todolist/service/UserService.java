package com.todolist.service;

import java.util.List;

import com.todolist.domain.User;

/**
 * 对应DAO的相应注释
 * @author shun
 */
public interface UserService {

	public boolean add(User user);
	
	public boolean update(User user);
	
	public boolean delete(int id);
	
	public User get(int id);
	
	public User getByUserId(String userId);
	
	public List<User> getList();
	
}
