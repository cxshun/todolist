package com.todolist.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	private List<TodoItem> todoItemList;
	
	private TodoItem todoItem;
	private String message;
	private String dateType; //日期类型,三天，一个星期，一个月，三个月
	
	private Map<String,Object> session = new HashMap<String,Object>();
	
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public Map<String,Object> getSession() {
		return session;
	}
	
	public String getDateType() {
		return dateType;
	}
	
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setTodoItem(TodoItem todoItem) {
		this.todoItem = todoItem;
	}
	
	public TodoItem getTodoItem() {
		return this.todoItem;
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
			message ="更新成功了";
		} else {
			message = "更新失败了";
		}
		return "todoitem_info";
	}
	
	/**
	 * 取得所有的ToDoItem
	 * @return
	 */
	public String list() {
		String userId = (String)session.get("userId");
		if (userId != null && !"".equals(userId)) {
			todoItemList = todoItemService.getList(Integer.valueOf(userId));//取得所有todoItem
		}
		return "todoitem_list";
	}
	
}
