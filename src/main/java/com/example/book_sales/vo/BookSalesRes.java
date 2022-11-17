package com.example.book_sales.vo;

import java.util.List;

import com.example.book_sales.entity.BookSales;
import com.example.book_sales.entity.BookSalesForConsumer;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookSalesRes {

	private BookSales bookSales;

	private List<BookSales> bookList;

	private String message;

	private List<BookSalesForConsumer> consumerbuyList;

	private int totalPrice;

	public BookSalesRes() {

	}

	public BookSalesRes(String message) {
		this.message = message;
	}

	public BookSalesRes(BookSales bookSales, String message) {
		this.bookSales = bookSales;
		this.message = message;
	}

	public BookSales getBookSales() {
		return bookSales;
	}

	public void setBookSales(BookSales bookSales) {
		this.bookSales = bookSales;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<BookSales> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookSales> bookList) {
		this.bookList = bookList;
	}

	public List<BookSalesForConsumer> getConsumerbuyList() {
		return consumerbuyList;
	}

	public void setConsumerbuyList(List<BookSalesForConsumer> consumerbuyList) {
		this.consumerbuyList = consumerbuyList;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
