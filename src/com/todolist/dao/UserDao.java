package com.todolist.dao;

import java.util.List;

import com.todolist.domain.TodoItem;
import com.todolist.domain.User;

/**
 * 有关用户的相关操作
 * @author shun
 */
public interface UserDao {

	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public boolean add(User user);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public boolean update(User user);
	
	/**
	 * 根据用户ID删除用户
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
	
	/**
	 * 根据用户ID取得用户信息
	 * @param id
	 * @return
	 */
	public User get(int id);
	
	/**
	 * 根据用户登录名取得用户信息
	 * @param loginId
	 * @return
	 */
	public User getByLoginId(String loginId);
	
	/**
	 * 根据用户ID取得ToDoItem列表
	 * @param id
	 * @return
	 */
	public List<TodoItem> getToDoItemListById(int id);
	
	/**
	 * 取得用户列表
	 * @return
	 */
	public List<User> getList();
	
}
