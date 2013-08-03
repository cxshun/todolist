package com.todolist.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class JsonUtils {

	/**
	 * 把List转换成Json字符串
	 * @param list
	 * @return
	 */
	public static String convertToJson(List<?> list) {
		Object rtn = null;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < list.size(); i ++) {
			//多于一个，需要用,来进行分割
			if (i > 0) {
				sb.append(",");
			}
			sb.append("{");
			Object obj = list.get(i);
			Class<?> cls = obj.getClass();
			try {
				Method[] methodArr = cls.getDeclaredMethods();
				for (int j = 0; j < methodArr.length; j ++) {
					Method method = methodArr[j];
					if (method.getName().startsWith("get")) {
						rtn = method.invoke(obj);
						if (rtn != null) {
							//多于一个，需要用,来分割
							if (j > 0){
								sb.append(",");
							}
							sb.append("\"").append(getFieldName(method.getName())).append("\":\"").append(method.invoke(obj)).append("\"");
						}
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			sb.append("}");
		}
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * 通过方法名称取得相应的属性名称
	 * @param fieldName
	 * @return
	 */
	private static String getFieldName(String MethodName) {
		String firstLetter = MethodName.substring("get".length()).substring(0, 1).toLowerCase();
		return firstLetter + MethodName.substring("get".length() + 1);
	}
	
}
