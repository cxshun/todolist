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
	private String loginId;
	private String password;
	private String address;
	private int sex;//性别，1为男，0为女
	private String email;
	List<TodoItem> todoItemList;
	
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
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
