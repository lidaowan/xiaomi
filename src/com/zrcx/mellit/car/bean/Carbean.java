package com.zrcx.mellit.car.bean;

public class Carbean {
Integer id;
Integer userd_id;
Integer goods_id;
Integer num;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getUserd_id() {
	return userd_id;
}
public void setUserd_id(Integer userd_id) {
	this.userd_id = userd_id;
}
public Integer getGoods_id() {
	return goods_id;
}
public void setGoods_id(Integer goods_id) {
	this.goods_id = goods_id;
}
public Integer getNum() {
	return num;
}
public void setNum(Integer num) {
	this.num = num;
}
@Override
public String toString() {
	return "Carbean [id=" + id + ", userd_id=" + userd_id + ", goods_id="
			+ goods_id + ", num=" + num + "]";
}

}
