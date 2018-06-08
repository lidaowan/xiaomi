<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.666666.com" prefix="j" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<script>
function search(){
	var phone = document.getElementById("phone").value;
	
	location.href="/xiaomi1/page/admin/page/page/user/table.action?phone="+phone;
}
function del(userid){
	if(confirm("确定删除此用户吗？")){
	location.href="/xiaomi1/page/admin/page/page/user/deluser.action?user_id="+userid;}
}
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 用户管理 &rarr; <span>用户管理</span>
	</div>
	<div class="searchdiv">
		<div>文件名称：<input id="phone" type="text" value="${search }"/></div><div class="btn1" onclick="search();">查 找</div>
		<div class="btn1" onclick="location.href='add.jsp';">添加</div>
	</div>
	<table class="table">
		<tr>
			<th style="width:50px;">ID</th>
			<th style="width:150px;">电话</th>
			<th style="width:100px;">操作</th>
		</tr>
		<c:forEach items="${list }" var="userbean">
		<tr>
				<td align="center" >${userbean.id }</td>
				<td align="center">${userbean.phone }</td>
				<td align="center">
					<a href="/xiaomi1/page/admin/page/page/user/xiugai.action?userid=${userbean.id }"><div class="modify"  title="修改"></div></a>
					 <div class="del"  title="删除" onclick="del(${userbean.id})"></div>
            </td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3" valign="middle" style="background:#F6F6F6">
				<form action="/xiaomi1/page/admin/page/page/user/table.action"><j:navigator/></form>
			</td>
		</tr>
		
	</table>
</body>
</html>
