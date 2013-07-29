<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<c:url value='/style/main.css' />" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/script/bootstrap/css/bootstrap.min.css' />" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/script/bootstrap/css/bootstrap-responsive.min.css' />" />
		<script type="text/javascript" src="<c:url value='/script/jquery-2.0.2.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/script/bootstrap/js/bootstrap.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/script/main.js' />"></script>
		<title>${user.userId}的todolist</title>
	</head>
<body>
	<div class="container">
		<div id="leftNav">
			${user.userId }<a href="<c:url value='/user/logout' />" class="btn btn-primary">退出</a>
		</div>
		
		<ul class="nav nav-tabs" >
			<li class="active"><a href="#unfinished" data-toggle="tab">已完成</a></li>
			<li><a href="#finished" data-toggle="tab">未完成</a></li>
		</ul>
		
		<div class="tab-content">
			<div class="tab-pane active" id="unfinished">
				<ul>
					<c:forEach items="${todoItemList}" var="todoItem">
						<li><input type="checkbox" name="isFinished" value="true" />
							${todoItem.content }</li>
					</c:forEach>
				</ul>
			</div>
			<div class="tab-pane" id="finished">
				<ul>
					<c:forEach items="${todoItemList}" var="todoItem">
						<li><input type="checkbox" name="isFinished" value="true" />
							${todoItem.content }</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	
		<div class="modal fade" id="edit-div">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">添加Todo</h4>
					</div>
					<div class="modal-body">
						<form class="bs-example" id="save-form">
							<input type="text" class="input-block-level" name="todoItem.title" placeholder="TODO标题"/>
							<textarea class="form-control input-block-level" name="todoItem.content" placeholder="TODO内容" rows="3"></textarea>
							<div id="datetimepicker" class="input-append">
								<input type="text" value="2013-07-28 21:21" id="datetimepicker" data-format="yyyy-MM-dd hh:mm"/>
								<span class="add-on"><i data-time-icon="icon-time" data-date-icon="icon-calendar"></i></span>
							</div>
							<div class="form-control">
								<select id="category-select" name="todoitem.category.id">
									<c:forEach items="${categoryList }" var="category">
										<option value="${category.id }">${category.name }</option>
									</c:forEach>
								</select>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="save" data-action="<c:url value='/todoitem/save.action' />">保存</button>
						<button type="button" class="btn btn-default" id="close">关闭</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>