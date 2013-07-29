package com.todolist.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 每一个用户的基本信息
 * @author shun
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String userId;
	private String password;
	private int sex;//性别，1为男，0为女
	private String email;
	private List<TodoItem> todoItemList;
	
	public List<TodoItem> getTodoItemList() {
		return todoItemList;
	}
	public void setTodoItemList(List<TodoItem> todoItemList) {
		this.todoItemList = todoItemList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
