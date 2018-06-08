package com.zrcx.mellit.user.bean;

public class Userbean {
String phone;
String pwd;
Integer id;
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Override
public String toString() {
	return "Userbean [phone=" + phone + ", pwd=" + pwd + ", id=" + id + "]";
}

}
