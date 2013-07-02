package com.todolist.dao;

import java.util.List;

import com.todolist.domain.Category;

/**
 * 跟分类相关的操作，包含增删改查
 * @author shun
 */
public interface CategoryDao {

	/**
	 * 添加分类
	 * @param category
	 * @return
	 */
	public boolean add(Category category);
	
	/**
	 * 更新分类信息
	 * @param category
	 * @return
	 */
	public boolean update(Category category);
	
	/**
	 * 根据ID删除分类
	 * @param id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 根据ID取得分类信息
	 * @param id
	 * @return
	 */
	public Category get(int id);
	
	/**
	 * 取得分类列表
	 * @return
	 */
	public List<Category> getList();
	
	/**
	 * 根据TODOITEM的id取得其对应的分类
	 * @param todoItemId
	 * @return
	 */
	public Category getByToDoItem(int todoItemId);
	
}
