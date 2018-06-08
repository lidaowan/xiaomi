package com.zrcx.mellit.gorders.bean;

public class Gorderbean {
	private Integer id;
	private Integer user_id;
	private Integer order_id;
	private Integer goods_id;
	private Integer num;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
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
		return "Gorderbean [id=" + id + ", user_id=" + user_id + ", order_id="
				+ order_id + ", goods_id=" + goods_id + ", num=" + num + "]";
	}
	

}
