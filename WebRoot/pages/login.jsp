<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../script/bootstrap/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../script/bootstrap/css/bootstrap-responsive.css" />
	<style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-login {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-login .form-login-heading,
      .form-login .checkbox {
        margin-bottom: 10px;
      }
      .form-login input[type="text"],
      .form-login input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
    </style>
<title>用户登录</title>
</head>
<body>
	<div class="container">
		<form class="form-login" action="<c:url value='/user/add'/>" method="post">
			<h2 class="form-login-heading">请登录</h2>
			<input type="text" class="input-block-level" name="user.loginId"  placeholder="用户名"/>
			<input type="text" class="input-block-level" name="user.password"  placeholder="密码"/>
			<input type="submit"  class="btn btn-large btn-primary" value="登录" />&nbsp;&nbsp;
			<a href="<c:url value='/pages/register.jsp' />">新用户注册</a>
		</form>
	</div>
</body>
</html>