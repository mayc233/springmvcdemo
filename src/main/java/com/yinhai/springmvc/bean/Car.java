package com.yinhai.springmvc.bean;

import java.util.List;
import java.util.Map;
/**
 * 购物车的实体
 * @author casper
 */
public class Car {
	private String id;
	private User user;
	private List<Goods> goodsList;
	private Map<String,String> maps;
	
	public Car() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	
	
	
	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}

	@Override
	public String toString() {
		return "Car [i d=" + id + ", user=" + user + ", goodsList=" + goodsList + ", maps=" + maps + "]";
	}

}
