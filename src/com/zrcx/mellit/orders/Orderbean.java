package com.zrcx.mellit.orders;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Orderbean {
private Integer id;
private String code;
private Timestamp time;
private Integer state;
private Integer user_id;
private Integer addr_id;

private BigDecimal num;

public BigDecimal getNum() {
	return num;
}
public void setNum(BigDecimal num) {
	this.num = num;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public Timestamp getTime() {
	return time;
}
public void setTime(Timestamp time) {
	this.time = time;
}
public Integer getState() {
	return state;
}
public void setState(Integer state) {
	this.state = state;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public Integer getAddr_id() {
	return addr_id;
}
public void setAddr_id(Integer addr_id) {
	this.addr_id = addr_id;
}
@Override
public String toString() {
	return "Orderbean [id=" + id + ", code=" + code + ", time=" + time
			+ ", state=" + state + ", user_id=" + user_id + ", addr_id="
			+ addr_id + "]";
}

}
