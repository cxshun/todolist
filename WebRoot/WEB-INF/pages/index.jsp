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
	<div class="container" >
		<div id="banner" class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="">EasyTodo</a>
			</div>
		</div>
	
		<div id="leftNav" class="table-bordered border-radius text-center">
			<img src="<c:url value='/images/logo.jpg' />" class="img-rounded"/>
			${user.userId }<a href="<c:url value='/user/logout.action' />" class="btn btn-primary">退出</a>
		</div>
		
		<div id="rightContent" class="table-bordered" >
			<ul class="nav nav-tabs">
				<li class="active"><a href="#unfinished" data-toggle="tab">未完成</a></li>
				<li><a href="#finished" data-toggle="tab" data-listUrl="<c:url value='/todoitem/list.action' />">已完成</a></li>
				<li class="pull-right"><button type="button" class="btn btn-promary refresh" 
					data-loading-text="正在加载..." data-listUrl="<c:url value='/todoitem/list.action' />">重新加载</button></li>
			</ul>
			
			<div class="tab-content well well-large">
				<div class="tab-pane active" id="unfinished">
					<ul class="unstyled table">
						<li>
							<input type="text" class="input-block-level" 
								data-getUrl="<c:url value='/todoitem/getLastest.action' />" 
								data-actionUrl="<c:url value='/todoitem/save.action' />" 
								data-deleteUrl="<c:url value='/todoitem/delete.action' />"
								data-updateUrl="<c:url value='/todoitem/update.action' />"
								placeholder="+增加新事项(按回车添加)" name="todoItem.content" />
						</li>
						<c:forEach items="${todoItemList}" var="todoItem">
							<li class="clearfix" data-itemid="${todoItem.id }">
								<label class="checkbox pull-left"><input type="checkbox" name="isFinished" value="true" />${todoItem.content }</label>
								<span class="pull-right	">
									<a href="#myModal" class="close">&times;</a>
								</span>
							</li>
						</c:forEach>
					</ul>
					<input type="button" class="btn btn-primary more" data-startIndex="${pageBean.startIndex }" 
						data-endIndex="${pageBean.endIndex }"
						data-listUrl="<c:url value='/todoitem/list.action' />" 
						data-loading-text="正在加载..." value="更多"/>
				</div>
				<div class="tab-pane" id="finished">
					<ul class="unstyled">
						<li class=".none"></li>
					</ul>
					<input type="button" class="btn btn-primary more" data-startIndex="${pageBean.startIndex }"
						data-endIndex="${pageBean.endIndex }" 
						data-listUrl="<c:url value='/todoitem/list.action' />" 
						data-loading-text="正在加载..." value="更多"/>
				</div>
			</div>
		</div>
		
		<!-- 确认删除接口 -->
		<div id="myModal" class="modal hide fade">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3>温馨提示</h3>
			</div>
			<div class="modal-body">
				确定要删除吗?
			</div>
			<div class="modal-footer">
				<a href="#" class="btn ok">确定</a>
				<a href="#" class="btn btn-primary cancel">取消</a>
			</div>
		</div>
	</div>
</body>
</html>