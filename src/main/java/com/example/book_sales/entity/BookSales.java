package com.example.book_sales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.book_sales.vo.BookSalesReq;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "bookinventory")
public class BookSales {

	@Column(name = "book_title")
	private String bookTitle;

	@Id
	@Column(name = "isbn")
	private String isbn;

	@Column(name = "author")
	private String author;

	@Column(name = "price")
	private Integer price;

	@Column(name = "inventory_quantity")
	private Integer inventoryQuantity;

	@Column(name = "sales_volume")
	private Integer salesVolume;

	@Column(name = "classification")
	private String classification;

	public BookSales() {

	}

	public BookSales(BookSalesReq req) {
		this.bookTitle = req.getBookTitle();
		this.isbn = req.getIsbn();
		this.author = req.getAuthor();
		this.price = req.getPrice();
		this.inventoryQuantity = req.getInventoryQuantity();
		this.salesVolume = req.getSalesVolume();
		this.classification = req.getClassification();
	}

	public BookSales(String bookTitle, String isbn, String author, Integer price, Integer inventoryQuantity,
			Integer salesVolume, String classification) {
		this.bookTitle = bookTitle;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.inventoryQuantity = inventoryQuantity;
		this.salesVolume = salesVolume;
		this.classification = classification;
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
}
