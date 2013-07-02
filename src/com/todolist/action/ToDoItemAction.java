package com.todolist.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.domain.TodoItem;
import com.todolist.service.ToDoItemService;

/**
 * 跟ToDoItem相关的操作控制
 * @author shun
 */
@Component(value="todoItemAction")
public class ToDoItemAction {

	@Autowired
	private ToDoItemService todoItemService;
	
	private int id;
	private List<TodoItem> todoItemList;
	private TodoItem todoItem;
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setTodoItem(TodoItem todoItem) {
		this.todoItem = todoItem;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<TodoItem> getToDoItemList() {
		return todoItemList;
	}
	
	/**
	 * 添加ToDoItem
	 * @return
	 */
	public String add() {
		boolean flag = todoItemService.add(todoItem);
		if (flag) {
			message = "添加成功了";
		} else {
			message = "添加失败了";
		}
		return "todoitem_list";
	}
	
	/**
	 * 更新ToDoItem
	 * @return
	 */
	public String update() {
		boolean flag = todoItemService.update(todoItem);
		if (flag) {
			message ="添加成功了";
		} else {
			message = "添加失败了";
		}
		return "todoitem_info";
	}
	
	/**
	 * 删除指定ID的ToDoItem
	 * @return
	 */
	public String delete() {
		boolean flag = todoItemService.delete(id);
		if (flag) {
			message = "添加成功了";
		} else {
			message = "添加失败了";
		}
		return "todoitem_list";
	}
	
	/**
	 * 根据分类号取得该分类下的ToDoItem
	 * @return
	 */
	public String listByCategoryId() {
		todoItemList = todoItemService.getByCategory(id);
		return "todoitem_list";
	}
	
	/**
	 * 取得所有的ToDoItem
	 * @return
	 */
	public String list() {
		todoItemList = todoItemService.getList();
		return "todoitem_list";
	}
	
}
