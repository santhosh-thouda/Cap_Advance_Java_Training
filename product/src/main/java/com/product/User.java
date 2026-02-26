package com.product;

public class User {
	
	public static void main(String[] args) {
		
		ProductDao dao = new ProductDao();
		
		Product p = new Product();
		
		p.setId(3);
		p.setName("Pencil");
		p.setPrice(100);
		p.setQuantity(20);
		
		dao.insertProduct(p);
	}

}