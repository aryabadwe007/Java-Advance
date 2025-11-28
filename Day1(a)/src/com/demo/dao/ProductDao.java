package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {



	boolean removeByID(int id);

	boolean save(Product p);

	boolean updateById(int id, int qty, double price);

	List<Product> findAllProducts();

	Product findById(int id);

	List<Product> arrangeByPrice();

	void closeMyConnection();

}
