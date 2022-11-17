package com.example.book_sales.vo;

import java.util.Map;

public class BookSalesReq {

	private String bookTitle;

	private String isbn;

	private String author;

	private Integer price;

	private Integer inventoryQuantity;

	private Integer salesVolume;

	private String classification;
	
	private Boolean permission;
	
	private Integer purchaseQuantity;

	private Map<String, Integer> consumerBuy;
	
	public BookSalesReq() {

	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(Integer inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	public Integer getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Boolean getPermission() {
		return permission;
	}

	public void setPermission(Boolean permission) {
		this.permission = permission;
	}

	public Integer getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public Map<String, Integer> getConsumerBuy() {
		return consumerBuy;
	}

	public void setConsumerBuy(Map<String, Integer> consumerBuy) {
		this.consumerBuy = consumerBuy;
	}

	
}
