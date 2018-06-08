package com.zrcx.mellit.goods.bean;

import java.math.BigDecimal;

public class Goodbean {
     
	  Integer id;
	String name;
	String image;
	BigDecimal price;
	String describes;
	Integer gclass;
	String gclassname;
	
	public String getGclassname() {
		return gclassname;
	}
	public void setGclassname(String gclassname) {
		this.gclassname = gclassname;
	}
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public Integer getGclass() {
		return gclass;
	}
	public void setGclass(Integer gclass) {
		this.gclass = gclass;
	}
	@Override
	public String toString() {
		return "Goodbean [id=" + id + ", name=" + name + ", image=" + image
				+ ", price=" + price + ", describes=" + describes + ", gclass="
				+ gclass + "]";
	}
	
	
}
