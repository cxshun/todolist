package com.todolist.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.domain.PageBean;
import com.todolist.domain.TodoItem;
import com.todolist.service.TodoItemService;
import com.todolist.service.UserService;
import com.todolist.utils.JsonUtils;
import com.todolist.utils.ServletUtils;

/**
 * 跟ToDoItem相关的操作控制
 * @author shun
 */
@Component(value="todoItemAction")
public class ToDoItemAction implements SessionAware{

	@Autowired
	private TodoItemService todoItemService;
	
	@Autowired
	private UserService userService;
	
	private List<TodoItem> todoItemList;
	
	private TodoItem todoItem;
	private String message;
	private PageBean pageBean;
	
	private Map<String,Object> session;
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public Map<String,Object> getSession() {
		return session;
	}
	
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public PageBean getPageBean() {
		return pageBean;
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
	public void save() {
		Object obj = session.get("userId");
		if (obj != null) {
			todoItem.setUser(userService.getByUserId(obj.toString()));
			todoItem.setCreateDate(new Date());
			boolean flag = todoItemService.add(todoItem);
			if (flag) {
				ServletUtils.writeToResponse(String.valueOf(true));
			}
		}
	}
	
	/**
	 * 更新ToDoItem
	 * @return
	 */
	public void update() {
		boolean flag = todoItemService.update(todoItem);
		if (flag) {
			ServletUtils.writeToResponse(String.valueOf(true));
		} 
	}
	
	/**
	 * 获取最新添加的todoItem
	 */
	public void getLastest() {
		String userId = (String)session.get("userId");
		todoItem = todoItemService.getLastest(userId);
		ServletUtils.writeToResponse(String.valueOf(todoItem.getId()));
	}
	
	/**
	 * 根据ID获取todoItem信息
	 */
	public void get() {
		todoItem = todoItemService.get(todoItem.getId());
	}
	
	/**
	 * 删除指定的TODOITEM
	 */
	public void delete() {
		boolean flag = todoItemService.delete(todoItem.getId());
		if (flag) {
			ServletUtils.writeToResponse(String.valueOf(true));
		}
	}
	
	/**
	 * 列出当前用户的所有未完成的TODOITEM
	 */
	public void list() {
		Object obj = session.get("userId");
		if (obj != null) {
			String userId = obj.toString();
			todoItemList = todoItemService.getList(userId,todoItem.getIsFinished(),pageBean);
		} 
		ServletUtils.writeToResponse(JsonUtils.convertToJson(todoItemList));
	}
	
}
