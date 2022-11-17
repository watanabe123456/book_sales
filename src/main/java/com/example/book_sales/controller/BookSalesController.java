package com.example.book_sales.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_sales.constants.BookClassification;
import com.example.book_sales.constants.BookSalesRtnCode;
import com.example.book_sales.entity.BookSales;
import com.example.book_sales.service.ifs.BookSalesService;
import com.example.book_sales.vo.BookSalesReq;
import com.example.book_sales.vo.BookSalesRes;

@RestController
public class BookSalesController {

	@Autowired
	private BookSalesService bookSalesService;

	@PostMapping(value = "/api/addBooksInfo")
	public BookSalesRes addBooksInfo(@RequestBody BookSalesReq req) {
		BookSalesRes checkResult = checkParam(req);
		if (checkResult != null) {
			return checkResult;
		}
		BookSales book = bookSalesService.addBooksInfo(req);
		if (book == null) {
			return new BookSalesRes(BookSalesRtnCode.ISBN_EXISTED.getMessage());
		}
		return new BookSalesRes(book, BookSalesRtnCode.SUCCESSFUL.getMessage());
	}

	private BookSalesRes checkParam(BookSalesReq req) {
		if (!StringUtils.hasText(req.getBookTitle())) {
			return new BookSalesRes(BookSalesRtnCode.BOOK_TITLE_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(req.getIsbn())) {
			return new BookSalesRes(BookSalesRtnCode.ISBN_REQUIRED.getMessage());
		} else if (req.getIsbn().length() != 13 && req.getIsbn().length() != 10) {
			return new BookSalesRes(BookSalesRtnCode.ISBN_LENGTH_ERROR.getMessage());
		} else if (!StringUtils.hasText(req.getAuthor())) {
			return new BookSalesRes(BookSalesRtnCode.AUTHOR_REQUIRED.getMessage());
		} else if (req.getPrice() == null || req.getPrice() == 0) {
			return new BookSalesRes(BookSalesRtnCode.PRICE_REQUIRED.getMessage());
		} else if (req.getInventoryQuantity() == null || req.getInventoryQuantity() == 0) {
			return new BookSalesRes(BookSalesRtnCode.INVENTORY_QUANTITY_REQUIRED.getMessage());
		} else if (req.getSalesVolume() == null || req.getSalesVolume() == 0) {
			return new BookSalesRes(BookSalesRtnCode.SALES_VOLUME_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(req.getClassification())) {
			return new BookSalesRes(BookSalesRtnCode.CLASSIFICATION_REQUIRED.getMessage());
		}
		return null;
	}

	@PostMapping(value = "/api/reviseBooksInfo")
	public BookSalesRes reviseBooksInfo(@RequestBody BookSalesReq req) {
		return bookSalesService.reviseBooksInfo(req);
	}

	@PostMapping(value = "/api/findBooksInfoByclassification")
	public BookSalesRes findBooksInfoByclassification(@RequestBody BookSalesReq req) {
		BookSalesRes res = new BookSalesRes();
		List<String> bookClassificationList = new ArrayList<>();
		bookClassificationList.add(BookClassification.MAGAZINE.getClassificaion());
		bookClassificationList.add(BookClassification.NOVEL.getClassificaion());
		bookClassificationList.add(BookClassification.PHOTO.getClassificaion());
		bookClassificationList.add(BookClassification.FOREIGN_LITERATURE.getClassificaion());
		bookClassificationList.add(BookClassification.SOCIOLOGY.getClassificaion());
		bookClassificationList.add(BookClassification.PSYCHOLOGY.getClassificaion());
		bookClassificationList.add(BookClassification.GEOGRAPHY.getClassificaion());
		if (!StringUtils.hasText(req.getClassification()) || req.getClassification().length() <= 1) {
			res.setMessage("請輸入正確的分類");
			return res;
		}

		if (!bookClassificationList.stream().anyMatch(item -> item.equalsIgnoreCase(req.getClassification()))) {
			res.setMessage("請輸入正確的分類");
			return res;
		}

		res.setBookList(bookSalesService.findBooksInfoByClassification(req.getClassification()));
		res.setMessage("成功");
		return res;
	}

	@PostMapping(value = "/api/findBooksInfoByTitleOrIsbnOrAuthor")
	public BookSalesRes findByBookTitleOrIsbnOrAuthor(@RequestBody BookSalesReq req) {
		return bookSalesService.findByBookTitleOrIsbnOrAuthor(req);
	}

	@PostMapping(value = "/api/updateInventoryQuantity")
	public BookSalesRes updateInventoryQuantity(@RequestBody BookSalesReq req) {
		return bookSalesService.updateInventoryQuantity(req);
	}

	@PostMapping(value = "/api/updatePrice")
	public BookSalesRes updatePrice(@RequestBody BookSalesReq req) {
		return bookSalesService.updatePrice(req);
	}

	@PostMapping(value = "/api/buy")
	public BookSalesRes buy(@RequestBody BookSalesReq req) {
		return bookSalesService.buy(req.getConsumerBuy());
	}

	@PostMapping(value = "/api/salesVolumeRank")
	public List<BookSales> salesVolumeRank() {
//		List<BookSales> salesVolume = bookSalesService.salesVolumeRank();
//		return salesVolume;
		return bookSalesService.salesVolumeRank();
	}
}
