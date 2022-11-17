package com.example.book_sales.constants;

public enum BookSalesRtnCode {
	
	SUCCESSFUL("200", "Successful"),
	BOOK_TITLE_REQUIRED("400", "Book title cannot be null or empty!!"),
	ISBN_REQUIRED("400", "ISBN cannot be null or empty!!"),
	ISBN_LENGTH_ERROR("400", "ISBN must be 10 or 13 words"),
	AUTHOR_REQUIRED("400", "Author cannot be null or empty!!"),
	PRICE_REQUIRED("400", "Price cannot be null or empty!!"),
	INVENTORY_QUANTITY_REQUIRED("400", "Inventory quantity cannot be null or empty!!"),
	SALES_VOLUME_REQUIRED("400", "Sales volume cannot be null or empty!!"),
	CLASSIFICATION_REQUIRED("400", "Classification cannot be null or empty!!"),
	ISBN_EXISTED("403", "ISBN existed");
	
	private String code;

	private String message;
	
	private BookSalesRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
