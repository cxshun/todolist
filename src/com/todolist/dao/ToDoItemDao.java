package com.todolist.dao;

import java.util.List;

import com.todolist.domain.TodoItem;

/**
 * 跟TODOITEM相关的操作，包括增删改查
 * @author shun
 */
public interface ToDoItemDao {

	/**
	 * 添加TODOITEM
	 * @param todoItem
	 * @return
	 */
	public boolean add(TodoItem todoItem);
	
	/**
	 * 更新TODOITEM
	 * @param todoItem
	 * @return
	 */
	public boolean update(TodoItem todoItem);
	
	/**
	 * 根据ID取得相应的TODOITEM
	 * @param id
	 * @return
	 */
	public TodoItem get(int id);
	
	/**
	 * 取得ToDoItem列表
	 * @return
	 */
	public List<TodoItem> getList();
	
	/**
	 * 取得某个用户的todoItem列表
	 * @param userId
	 * @return
	 */
	public List<TodoItem> getList(int userId);
	
}
