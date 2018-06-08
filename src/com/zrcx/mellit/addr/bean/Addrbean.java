package com.zrcx.mellit.addr.bean;

public class Addrbean {
private Integer id;
private String name;
private String province;
private String city;
private String district;
private String street;
private String postcode;
private String phone;
private Integer user_id;
private Integer state;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getPostcode() {
	return postcode;
}
public void setPostcode(String postcode) {
	this.postcode = postcode;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public Integer getState() {
	return state;
}
public void setState(Integer state) {
	this.state = state;
}
@Override
public String toString() {
	return "Addrbean [id=" + id + ", name=" + name + ", province=" + province
			+ ", city=" + city + ", district=" + district + ", street="
			+ street + ", postcode=" + postcode + ", phone=" + phone
			+ ", user_id=" + user_id + ", state=" + state + "]";
}


}
