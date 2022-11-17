package com.example.book_sales.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.book_sales.entity.BookSales;
import com.example.book_sales.entity.BookSalesForConsumer;
import com.example.book_sales.repository.BookSalesDAO;
import com.example.book_sales.service.ifs.BookSalesService;
import com.example.book_sales.vo.BookSalesReq;
import com.example.book_sales.vo.BookSalesRes;

@Service
public class BookSalesServiceImpl implements BookSalesService {

	@Autowired
	private BookSalesDAO bookSalesDAO;

	@Override
	public BookSales addBooksInfo(BookSalesReq req) {
		// isbn���୫��

		if (bookSalesDAO.existsById(req.getIsbn())) {
			return null;
		}
		BookSales book = new BookSales(req);
		return bookSalesDAO.save(book);
	}

	@Override
	public BookSalesRes reviseBooksInfo(BookSalesReq req) {

		BookSalesRes res = new BookSalesRes();

		if (!StringUtils.hasText(req.getIsbn())) {
			res.setMessage("�п�J���T��isbn");
			return res;
		}

		Optional<BookSales> bookInfo = bookSalesDAO.findById(req.getIsbn());
		if (!bookInfo.isPresent()) {
			res.setMessage("�п�J���T��isbn");
			return res;
		}
		
		int nullCount = 6;

		BookSales bookSale = bookInfo.get();

		if (StringUtils.hasText(req.getBookTitle())) {
			bookSale.setBookTitle(req.getBookTitle());
			nullCount--;
		}

		if (StringUtils.hasText(req.getAuthor())) {
			bookSale.setAuthor(req.getAuthor());
			nullCount--;
		}

		if (req.getPrice() != null) {
			if (req.getPrice() <= 0) {
				res.setMessage("���椣�o���t�Ʃ�0");
				return res;
			}
			bookSale.setPrice(req.getPrice());
			nullCount--;
		}

		if (req.getInventoryQuantity() != null) {
			if (req.getInventoryQuantity() < 0) {
				res.setMessage("�w�s���o���t");
				return res;
			}
			bookSale.setInventoryQuantity(req.getInventoryQuantity());
			nullCount--;
		}

		if (req.getSalesVolume() != null) {
			if (req.getSalesVolume() < 0) {
				res.setMessage("�P��q���o���t");
				return res;
			}
			bookSale.setSalesVolume(req.getSalesVolume());
			nullCount--;
		}

		if (StringUtils.hasText(req.getClassification())) {
			bookSale.setClassification(req.getClassification());
			nullCount--;
		}
		if (nullCount == 6) {
			res.setMessage("���ܧ�������");
			return res;
		}
		bookSalesDAO.save(bookSale);
		res.setBookSales(bookSale);
		res.setMessage("�ק令�\");
		return res;
	}

	@Override
	public List<BookSales> findBooksInfoByClassification(String classification) {
		List<BookSales> bookList = bookSalesDAO.findAllByClassificationContaining(classification);
		for (BookSales item : bookList) {
			item.setSalesVolume(null);
			item.setClassification(null);
		}
		return bookList;
	}

	@Override
	public BookSalesRes findByBookTitleOrIsbnOrAuthor(BookSalesReq req) {
		BookSalesRes res = new BookSalesRes();

		if (!StringUtils.hasText(req.getBookTitle()) && !StringUtils.hasText(req.getIsbn())
				&& !StringUtils.hasText(req.getAuthor())) {
			res.setMessage("�п�J���T���j�M����");
			return res;
		}
		List<BookSales> bookList = bookSalesDAO.findByBookTitleOrIsbnOrAuthor(req.getBookTitle(), req.getIsbn(),
				req.getAuthor());

		if (bookList == null || bookList.isEmpty()) {
			res.setMessage("�d�L���");
			return res;
		}
		if (req.getPermission() == null || req.getPermission() == false) {
			for (BookSales item : bookList) {
				item.setInventoryQuantity(null);
				item.setSalesVolume(null);
				item.setClassification(null);
			}
		} else {
			for (BookSales item : bookList) {
				item.setClassification(null);
			}
		}

		res.setBookList(bookList);
		res.setMessage("���\");
		return res;
	}

	@Override
	public BookSalesRes updateInventoryQuantity(BookSalesReq req) {
		BookSalesRes res = new BookSalesRes();

		if (!StringUtils.hasText(req.getIsbn())) {
			res.setMessage("�п�J���T��isbn");
			return res;
		}
		Optional<BookSales> bookInfo = bookSalesDAO.findById(req.getIsbn());

		if (!bookInfo.isPresent()) {
			res.setMessage("�п�J���T��isbn");
			return res;
		}
		BookSales bookSales = bookInfo.get();
		if (req.getInventoryQuantity() != null) {
			if (req.getInventoryQuantity() < 0) {
				res.setMessage("�w�s���o���t");
				return res;
			}
			bookSales.setInventoryQuantity(req.getInventoryQuantity());
		} else {
			res.setMessage("�קﶵ�ؤ��o����");
			return res;
		}

		BookSales updatebookSales = bookSalesDAO.save(bookSales);
		updatebookSales.setSalesVolume(null);
		updatebookSales.setClassification(null);
		res.setBookSales(updatebookSales);
		return res;
	}

	@Override
	public BookSalesRes updatePrice(BookSalesReq req) {
		BookSalesRes res = new BookSalesRes();

		if (!StringUtils.hasText(req.getIsbn())) {
			res.setMessage("�п�J���T��isbn");
			return res;
		}
		Optional<BookSales> bookInfo = bookSalesDAO.findById(req.getIsbn());

		if (!bookInfo.isPresent()) {
			res.setMessage("�п�J���T��isbn");
			return res;
		}
		BookSales bookSales = bookInfo.get();
		if (req.getPrice() != null) {
			if (req.getPrice() <= 0) {
				res.setMessage("���椣�o���t��0");
				return res;
			}
			bookSales.setPrice(req.getPrice());
		} else {
			res.setMessage("�קﶵ�ؤ��o����");
			return res;
		}

		BookSales updatebookSales = bookSalesDAO.save(bookSales);
		updatebookSales.setSalesVolume(null);
		updatebookSales.setClassification(null);
		res.setBookSales(updatebookSales);
		return res;
	}

	@Override
	public BookSalesRes buy(Map<String, Integer> consumerBuy) {
		
		BookSalesRes res = new BookSalesRes();
		if(consumerBuy.isEmpty()) {
			res.setMessage("�Цܤ��ʶR�@��");
			return res;
		}
		
		List<BookSalesForConsumer> consumerbuyList = new ArrayList<>();

		int totalPrice = 0;
		
		for (var item : consumerBuy.entrySet()) {
			Optional<BookSales> consumerbuyOp = bookSalesDAO.findById(item.getKey());
			if (!consumerbuyOp.isPresent()) {
				res.setMessage("�d�L���");
				return res;
			}
			BookSales consumerbuy = consumerbuyOp.get();
			if (item.getValue() == null || item.getValue() <= 0) {
				if (item.getValue() != null && item.getValue() < 0) {
					res.setMessage("�ʶR�ƶq���o���t");
					return res;
				}
				res.setMessage("�ܤ��ʶR�@��");
				return res;
			}
			if ((consumerbuy.getInventoryQuantity() - item.getValue()) < 0) {
				res.setMessage("�w�s����");
				return res;
			}

			consumerbuy.setSalesVolume(consumerbuy.getSalesVolume() + item.getValue());
			consumerbuy.setInventoryQuantity(consumerbuy.getInventoryQuantity() - item.getValue());
			totalPrice += item.getValue() * consumerbuy.getPrice();
			bookSalesDAO.save(consumerbuy);
			consumerbuyList.add(
					new BookSalesForConsumer(consumerbuy.getBookTitle(), consumerbuy.getIsbn(), consumerbuy.getAuthor(),
							consumerbuy.getPrice(), item.getValue(), (item.getValue() * consumerbuy.getPrice())));
		}

		res.setTotalPrice(totalPrice);
		res.setConsumerbuyList(consumerbuyList);
		res.setMessage("�ʶR���\");
		return res;
	}

	@Override
	public List<BookSales> salesVolumeRank() {
		List<BookSales> salesVolume = bookSalesDAO.findTop5ByOrderBySalesVolumeDesc();
		for (BookSales item : salesVolume) {
			item.setInventoryQuantity(null);
			item.setSalesVolume(null);
			item.setClassification(null);
		}
		return salesVolume;
	}

}
