package com.example.book_sales.constants;

public enum BookClassification {

	MAGAZINE("���x"),
	NOVEL("�p��"),
	PHOTO("�g�u"),
	FOREIGN_LITERATURE("�~����"),
	SOCIOLOGY("���|��"),
	PSYCHOLOGY("�߲z��"),
	GEOGRAPHY("�a�z��");
	
	private String classificaion;
	
	private BookClassification(String classificaion) {
		this.classificaion = classificaion;
	}

	public String getClassificaion() {
		return classificaion;
	}
		
}
