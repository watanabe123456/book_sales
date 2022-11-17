package com.example.book_sales.service.ifs;

import java.util.List;
import java.util.Map;

import com.example.book_sales.entity.BookSales;
import com.example.book_sales.vo.BookSalesReq;
import com.example.book_sales.vo.BookSalesRes;

public interface BookSalesService {

	public BookSales addBooksInfo(BookSalesReq req);
	
	public BookSalesRes reviseBooksInfo(BookSalesReq req);
	
	public List<BookSales> findBooksInfoByClassification(String classification);
	
	public BookSalesRes findByBookTitleOrIsbnOrAuthor(BookSalesReq req);
	
	public BookSalesRes updateInventoryQuantity(BookSalesReq req);
	
	public BookSalesRes updatePrice(BookSalesReq req);
	
	public BookSalesRes buy(Map<String, Integer> consumerBuy);

	public List<BookSales> salesVolumeRank();
}
