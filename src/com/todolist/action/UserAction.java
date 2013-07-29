package com.todolist.action;

import java.util.HashMap;
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
	private Map<String,Object> session = new HashMap<String,Object>();
	private String message;
	private List<TodoItem> todoItemList;
	
	public List<TodoItem> getTodoItemList() {
		return todoItemList;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
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
	 * 进入登录页面，首先会检查一下用户是否已经登录，如果已经登录，直接跳转到todolist的首页
	 * @param session
	 * @return
	 */
	public String loginPage() {
		if (session.get("loginId") == null){
			return "login_page";
		}
		return "user_index";
	}
	
	/**
	 * 用户登录 
	 * @param session
	 * @return
	 */
	public String login() {
		User tmpUser = userService.getByUserId(user.getUserId());
		if (user.getPassword().equals(tmpUser.getPassword())) {
			session.put("loginId", user.getUserId());//登录成功后把LoginId放到session中
													//方便我们后面进行用户信息的获取
		} else {
			message = "密码或用户名错误";
			return "login_page";
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
	 * 注册页面
	 * @return
	 */
	public String registerPage() {
		return "register_page";
	}
	/**
	 * 用户注册
	 * @return
	 */
	public String add() {
		boolean flag = userService.add(user);
		if (flag) {
			user.setPassword("");
			session.put("userId", user.getUserId());
			message = "注册成功";
			return "user_index";
		} else {
			message = "注册失败";
			return "register_page";
		}
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
		User user = userService.getByUserId(userId);
		user.setPassword("");//把密码设空，暂时的安全策略 TODO
		return "user_info";
	}
	
}
