package com.example.book_sales;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.example.book_sales.repository.BookSalesDAO;
import com.example.book_sales.service.ifs.BookSalesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@SpringBootTest(classes = BookSalesApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookSalesApplicationTests {
	
	@Autowired
	private BookSalesService bookSalesService;
	
	@Autowired
	private BookSalesDAO bookSalesDAO;
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	private static final String CONTEN_TYPE = "application/json;charset=UTF-8";

	@Test
	public void addBooksInfoControllerTest() throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("bookTitle", "ABC");
		map.put("isbn", "9789575646752");
		map.put("author", "David");
		map.put("price", 250);
		map.put("purchaseQuantity", "5");
		map.put("salesVolume", "2");
		map.put("classification", "�p��,��v���");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String mapString = objectMapper.writeValueAsString(map);
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/addBooksInfo")
				.contentType(CONTEN_TYPE)// Headers �n�[���ѼƴN�u�� contentType ��,�i�����ϥ�,�����z�L Headers �[�J
//				.headers(headers)
				.content(mapString));
		//get response && �N response �����e�ন�r��
		String resString = result.andReturn().getResponse().getContentAsString();
		
		//�N�o�쪺 response �ন Json
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);
		String rtnMessage = (String) resData.get("message");
		System.out.println(rtnMessage);
		Assert.isTrue(rtnMessage.equals("Successful!!"), "Message error!!");
		Map<String, Object> rtnInfo = (Map<String, Object>) resData.get("books_info");// (Register) �q Object �૬�� Register
		Assert.isTrue(((String)rtnInfo.get("isbn")).equals("9789575642952"), "isbn error!!");
	}

}
