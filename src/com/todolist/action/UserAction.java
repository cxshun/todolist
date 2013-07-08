package com.todolist.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.todolist.domain.TodoItem;
import com.todolist.domain.User;
import com.todolist.service.UserService;

/**
 * 用户相关的操作
 * @author shun
 */
@Component(value="userAction")
public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	private User user;
	private int id;
	private Map<String,Object> session;
	private String message;
	private List<TodoItem> todoItemList;
	
	public List<TodoItem> getTodoItemList() {
		return todoItemList;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	
	/**
	 * 用户登录 
	 * @param session
	 * @return
	 */
	public String login(Map<String,Object> session) {
		User tmpUser = userService.getByLoginId(user.getLoginId());
		if (tmpUser.getPassword().equals(user.getPassword())) {
			session.put("LoginId", user.getLoginId());//登录成功后把LoginId放到session中
																										  //方便我们后面进行用户信息的获取
		} else {
			message = "密码或用户名错误";
			return "user_login";
		}
		return "user_index";
	}
	
	/**
	 * 用户注销登录
	 * @return
	 */
	public String logout() {
		session.remove("LoginId");
		return "user_login";
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	public String add() {
		boolean flag = userService.add(user);
		if (flag) {
			session.put("loginId", user.getLoginId());
			message = "注册成功";
		} else {
			message = "注册失败";
		}
		return "user_index";
	}
	
	/**
	 * 用户更新信息
	 * @return
	 */
	public String update() {
		boolean flag = userService.update(user);
		if (flag) {
			message = "更新成功";
		} else {
			message = "更新失败";
		}
		return "user_info";
	}
	
	/**
	 * 删除用户信息，这个需要放后台 TODO
	 * @return
	 */
	public String delete() {
		boolean flag = userService.delete(id);
		if (flag) {
			message = "删除成功";
		} else {
			message = "删除失败";
		}
		return "user_list";
	}
	
	/**
	 * 用户查看自己的信息
	 * @return
	 */
	public String get() {
		String userId = (String)session.get("loginId");
		User user = userService.getByLoginId(userId);
		user.setPassword("");//把密码设空，暂时的安全策略 TODO
		
		return "user_info";
	}
	
	/**
	 * 取得用户的所有TodoItem
	 * @return
	 */
	public String getToDoItemList() {
		todoItemList = userService.getToDoItemListById(id);
		return "todoitem_list";
	}
	
}
