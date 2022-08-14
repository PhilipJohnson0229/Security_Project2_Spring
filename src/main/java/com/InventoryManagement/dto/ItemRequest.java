package com.InventoryManagement.dto;

import javax.persistence.Entity;

import com.InventoryManagement.beans.Store;


public class ItemRequest {

	private String id;
	private String name;
	private String price;
	private String storeId;
	private String categoryId;
	
	
	
	public ItemRequest() {
		super();
	}
	
	public ItemRequest(String id, String name, String price, String storeId, String categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.storeId = storeId;
		this.categoryId = categoryId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ItemRequest [id=" + id + ", name=" + name + ", price=" + price + ", storeId=" + storeId
				+ ", categoryId=" + categoryId + "]";
	}
	
	
}
