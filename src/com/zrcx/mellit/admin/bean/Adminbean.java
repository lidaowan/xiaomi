package com.zrcx.mellit.admin.bean;

public class Adminbean {

	
	Integer id;
	String email;
	String image;
	String pwd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Adminbean [id=" + id + ", email=" + email + ", image=" + image
				+ ", pwd=" + pwd + "]";
	}
	
}
