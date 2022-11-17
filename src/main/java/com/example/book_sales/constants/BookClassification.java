package com.example.book_sales.constants;

public enum BookClassification {

	MAGAZINE("雜誌"),
	NOVEL("小說"),
	PHOTO("寫真"),
	FOREIGN_LITERATURE("外國文學"),
	SOCIOLOGY("社會學"),
	PSYCHOLOGY("心理學"),
	GEOGRAPHY("地理學");
	
	private String classificaion;
	
	private BookClassification(String classificaion) {
		this.classificaion = classificaion;
	}

	public String getClassificaion() {
		return classificaion;
	}
		
}
