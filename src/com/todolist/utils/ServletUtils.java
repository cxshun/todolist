package com.todolist.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class ServletUtils {

	/**
	 * 把内容通过json格式写出到response
	 * @param content
	 */
	public static void writeToResponse(String content) {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/json;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
}
