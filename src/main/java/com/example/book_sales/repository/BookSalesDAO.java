package com.example.book_sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.book_sales.entity.BookSales;

@Repository
public interface BookSalesDAO extends JpaRepository<BookSales, String>{
	
	public List<BookSales> findAllByClassificationContaining(String classification);
	
	public List<BookSales> findByBookTitleOrIsbnOrAuthor(String bookTitle, String isbn, String author);
//	@Query(value = "select b from BookSales b where b.bookTitle like %:bookTitle%")
//	public List<BookSales> findByBookTitleLike(@Param("bookTitle") String bookTitle);
//	
//	@Query(value = "select b from BookSales b where b.isbn like %:isbn%")
//	public List<BookSales> findByIsbnLike(@Param("isbn") String isbn);
//	
//	@Query(value = "select b from BookSales b where b.author like %:author%")
//	public List<BookSales> findByAuthorLike(@Param("author") String author);
	
	public List<BookSales> findTop5ByOrderBySalesVolumeDesc();
}
