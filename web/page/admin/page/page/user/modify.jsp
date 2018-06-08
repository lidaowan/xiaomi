<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理员管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../../../../common/check.js"></script>
<script>
	function isPost(){
		var ispost = true;
		var pwd1 = document.getElementById("pwd1").value;
		var pwd2 = document.getElementById("pwd2").value;
		if(isNull(pwd1)){
			document.getElementById("mg_pwd1").innerHTML="密码不能为空。";
			ispost = false;
		}else if(pwd1.length<5 || pwd1.length>20){
			document.getElementById("mg_pwd1").innerHTML="密码长度为5-20。";
			ispost = false;
			
		}else{
			document.getElementById("mg_pwd1").innerHTML="";

		}
		
		if(pwd1!=pwd2){
			document.getElementById("mg_pwd2").innerHTML="两次输入的密码不一致。";
			ispost = false;
			
		}else{
			document.getElementById("mg_pwd2").innerHTML="";

		}
		return ispost;
	}
</script>
</head>
<body>

<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 管理员管理 &rarr; <span>管理员管理</span>
	</div>
	<form action="/xiaomi1/page/admin/page/page/user/zhenxiugai.action" method="post" onsubmit="return isPost();" >
	<table class="table">
		<input type=hidden name="id" value="${userbean.id }" />
		<tr>

			<th style="width: 150px;">手机号</th>
			<td><input type="text" name="email" value="${userbean.phone }" disabled="disabled"/></td>
		</tr>

		<tr>
			<th style="width: 150px;">密码</th>
			<td>
				<input type="password" id="pwd1" name="pwd" value="${userbean.pwd }" />
				<font style="color:red;" id="mg_pwd1"></font>
			
			</td>
		</tr>
		<tr>
			<th style="width: 150px;">确认密码</th>
			<td>
				<input type="password" id="pwd2"   />
				<font style="color:red;" id="mg_pwd2"></font>
			
			</td>
		</tr>
		
		<tr>
			<td colspan="4" valign="middle" style="background: #F6F6F6" align="center">
			<input type="submit" value="修改密码" style="border:1px solid #ccc;padding:10px 20px;" />
			</td>
		</tr>
	</table>
	</form>


</body>


</html>
