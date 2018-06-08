<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../../../../common/check.js"></script>

<script type="text/javascript">
function isPost(){
	var ispost=true;
	var phone = get("phone").value;
	var pwd1 = get("pwd1").value;
	var pwd2 = get("pwd2").value;
	
	if(isNull(phone)){
		
		get("mg_phone").innerHTML="手机号不能为空";
		ispost=false;
		
	}else if(!checkMobile(phone)){
		get("mg_phone").innerHTML="手机号格式不正确";
		
		ispost=false;

	}else{
		get("mg_phone").innerHTML="";

	}
	
	
	if(isNull(pwd1) || pwd1.length<5 || pwd1.length>20){
		get("mg_pwd").innerHTML="密码长度必须为5-20";
		ispost=false;

	}else {
		get("mg_pwd").innerHTML="";
		

	}
	
	if(pwd2!=pwd1){
		get("mg_pwd2").innerHTML="两次输入的密码不一样";
		ispost=false;
	}else{
		get("mg_pwd2").innerHTML="";

	}
	return ispost;
}
function get(id){
	return document.getElementById(id);
}
</script>
</head>
<body>

<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 用户管理 &rarr; <span>用户管理</span>
	</div>
	<form action="/xiaomi1/page/admin/page/page/user/adduser.action" method="post" onsubmit="return isPost();">
	<table class="table">
		<tr>
			<th style="width: 150px;">电话</th>
			<td><input type="text" name="phone" id="phone" />
				<font id="mg_phone" style="color:red;"></font>
			</td>
		</tr>

		<tr>
			<th style="width: 150px;">密码</th>
			<td>
				<input type="password" id="pwd1" name="pwd" />
				<font style="color:red;" id="mg_pwd"></font>
			</td>
		</tr>
		<tr>
			<th style="width: 150px;">确认密码</th>
			<td><input type="password" id="pwd2" /></td>
			<font style="color:red;" id="mg_pwd2"></font>
		</tr>

		<tr>
			<td colspan="3" valign="middle" style="background: #F6F6F6" align="center">
			<input type="submit" value="添加" style="border:1px solid #ccc;padding:10px 20px;" />
			</td>
		</tr>
	</table>
	</form>


</body>


</html>
