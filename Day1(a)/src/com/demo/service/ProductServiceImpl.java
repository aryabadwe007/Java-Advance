package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao pdao;

	   public ProductServiceImpl() {
		   pdao=new ProductDaoImpl();
	   }

	@Override
	public boolean addNewProduct() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enetr pid");
		int pid=sc.nextInt();
		System.out.println("enetr product name");
		String pname=sc.next();
		System.out.println("enetr quantity");
		int qty=sc.nextInt();
		System.out.println("enetr price");
		double price=sc.nextDouble();
		System.out.println("enter date");
		String dt=sc.next();
		
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Product p=new Product(pid,pname,qty,price,ldt);
		
		
		return pdao.save(p);
	}

	@Override
	public boolean deletebyid(int id) {
		return pdao.removeByID(id);
	}

	@Override
	public boolean modifybyId(int id, int qty, double price) {
		
		return pdao.updateById(id,qty,price);
	}

	@Override
	public Product getId(int id) {
		
		
		return pdao.findById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return pdao.findAllProducts();
	}

	@Override
	public void closeConnection() {
		
		
	}

	@Override
	public List<Product> sortByPrice() {
	
		return pdao.arrangeByPrice();
	}

	@Override
	public void closeMyConnetion() {
       pdao.closeMyConnection();
	}
	
}
