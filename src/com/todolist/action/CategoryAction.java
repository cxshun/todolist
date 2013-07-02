package com.todolist.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.domain.Category;
import com.todolist.service.CategoryService;

/**
 * 与分类相关的控制，都封装在此
 * @author shun
 */
@Component(value="categoryAction")
public class CategoryAction {

	@Autowired
	private CategoryService categoryService;
	
	private List<Category> categoryList;
	private Category category;
	private String message;
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getMessage() {
		return message;
	}
	
	public List<Category> getCategoryList() {
		return categoryList;
	}
	/**
	 * 添加分类
	 * @param category
	 * @return
	 */
	public String add( ) {
		boolean flag = categoryService.add(category);
		if (flag) {
			message = "添加成功了";
		} else {
			message = "添加失败了";
		}
		return "category_list";
	}
	
	/**
	 * 更新分类信息
	 * @return
	 */
	public String update( ) {
		boolean flag = categoryService.update(category);
		if (flag) {
			message = "更新成功了";
		} else {
			message = "更新失败了";
		}
		return "category_info";
	}
	
	/**
	 * TODO 删除指定分类编号的分类，其下的所有ToDoItem都会被删除。
	 * @return
	 */
	public String delete() {
		boolean flag = categoryService.delete(id);
		if ( flag ) {
			message = "删除成功了";
		} else {
			message = "删除失败了";
		}
		return "category_list";
	}
	
	/**
	 * 根据ToDoItem取得其所属的分类
	 * @return
	 */
	public String get() {
		category = categoryService.get(id);
		return "category_info";
	}
	
	/**
	 * 取得所有分类
	 * @return
	 */
	public String list() {
		categoryList = categoryService.getList();
		return "category_list";
	}
	
}
