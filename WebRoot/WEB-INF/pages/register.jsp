<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value='/script/bootstrap/css/bootstrap.min.css' />" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/script/bootstrap/css/bootstrap-responsive.min.css' />" />
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
    <script type="text/javascript" src="<c:url value='/script/jquery-2.0.2.min.js' />"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$("input").click(function(){
    			$("#message").html("");
    		});
    	});
    	function checkInput() {
    		var loginId = $("input[name='user.userId']").val();
    		var password = $("input[name='user.password']").val();
    		var repPassword = $("input[name='repPassword']").val();
    		var email = $("input[name='user.email']").val();
    		
    		if (loginId == ""){
    			$("#message").html("请输入用户名");
    			return false;
    		} else if (password == ""){
    			$("#message").html("请输入密码");
    			return false;
    		} else if (repPassword == "") {
    			$("#message").html("请输入重复密码");
    			return false;
    		} else if (password != repPassword) {
    			$("#message").html("两次输入密码不一致");
    			return false;
    		} else if (email == ""){
    			$("#message").html("请输入email");
    			return false;
    		}
    		return true;
    	}
    </script>
	<title>新用户注册</title>
</head>
<body>
	<div class="container">
		<form class="form-login" action="<c:url value='/user/doRegister.action'/>" method="post" onsubmit="return checkInput()">
			<h2 class="form-login-heading">注册信息</h2>
			<div class="alert"></div>
			<input type="text" class="input-block-level" name="user.userId"  placeholder="用户名"/>
			<input type="password" class="input-block-level" name="user.password"  placeholder="密码"/>
			<input type="password" class="input-block-level" name="repPassword" placeholder="重复密码" />
			<input type="text" class="input-block-level" name="user.email" placeholder="Email" />
			<div class="control-group">
				<div class="controls">
					<label class="radio inline" ><input type="radio" name="user.sex"  checked value="1"/>男</label>
					<label class="radio inline"><input type="radio" name="user.sex"  value="0"/>女</label>
				</div>
			</div>
			<input type="submit"  class="btn btn-large btn-primary" value="注册" />&nbsp;&nbsp;
		</form>
	</div>
</body>
</html>