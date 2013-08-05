package com.todolist.domain;

import java.io.Serializable;

public class PageBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private int startIndex;
	private int endIndex;
	private int pageSize;
	
	public PageBean(){}
	public PageBean(int startIndex,int endIndex,int pageSize) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.pageSize = pageSize;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
