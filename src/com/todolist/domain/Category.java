package com.todolist.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 任务的分类
 * @author shun
 */
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private List<TodoItem> todoItemList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TodoItem> getTodoItemList() {
		return todoItemList;
	}
	public void setTodoItemList(List<TodoItem> todoItemList) {
		this.todoItemList = todoItemList;
	}
	
}
