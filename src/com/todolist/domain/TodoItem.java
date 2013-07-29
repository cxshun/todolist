package com.todolist.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 每一个TODO项目
 * @author shun
 */
public class TodoItem implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String content;
	private Date endDate;
	private Date createDate;
	private boolean isFinish;
	private User user;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isFinish() {
		return isFinish;
	}
	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}
		
}
