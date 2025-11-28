package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addNewProduct();

	boolean deletebyid(int id);

	boolean modifybyId(int id, int qty, double price);


	Product getId(int id);

	List<Product> getAllProducts();

	void closeConnection();

	List<Product> sortByPrice();

	void closeMyConnetion();

}
