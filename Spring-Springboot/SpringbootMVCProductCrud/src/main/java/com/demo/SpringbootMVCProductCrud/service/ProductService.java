package com.demo.SpringbootMVCProductCrud.service;

import java.util.List;

import com.demo.SpringbootMVCProductCrud.beans.Product;

public interface ProductService {

	List<Product> findAllProducts();

	void addnewProduct(Product prod);

	Product getById(int pid);

	void updateProduct(Product prod);

	void deleteProduct(int pid);



}
