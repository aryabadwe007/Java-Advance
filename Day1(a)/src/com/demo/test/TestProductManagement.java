package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.service.ProductServiceImpl;
import com.demo.beans.Product;
import com.demo.dao.DBUtil;
import com.demo.service.ProductService;


public class TestProductManagement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
				ProductService pservice= new ProductServiceImpl();
		
		do {
			System.out.println("1. add new product\n2. delete product\n3. find by id");
			System.out.println("4.modify product\n5. display all\n6. display in sorted order\n7. exit");
			System.out.println("choice :");
			choice=sc.nextInt();
			switch(choice) {
			case 1->{
				boolean status=pservice.addNewProduct();
				if(status) {
					System.out.println("product addedd successfully");
				}else {
					System.out.println("Not added");
				}
			}
			case 2->{
				System.out.println("Enter id : ");
				int id = sc.nextInt();
				boolean	status = pservice.deletebyid(id);
				if(status) {
				System.out.println(" Product Deleted successfully");
				}else {
					System.out.println("Not deleted");
				}
			}
			
			case 3 ->{
				System.out.println("enter id");
				int id=sc.nextInt();
				Product p=pservice.getId(id);
				if(p==null) {
					System.out.println("not found");
				}else {
					System.out.println(p);
				}
				
				
			}
			case 4->{
			
				System.out.println("enter id ");
				int id=sc.nextInt();
				System.out.println("quntity");
				int qty=sc.nextInt();
				System.out.println("price");
				double price=sc.nextDouble();
				boolean status=pservice.modifybyId(id,qty,price);
				if(status) {
					System.out.println(" Product modified successfully");
					}else {
						System.out.println("Not modified");
					}
			}
			case 5->{
				List<Product> plst=pservice.getAllProducts();
				plst.forEach(System.out::println);
				
			}
			case 6->{
				List<Product> plst=pservice.sortByPrice();
				plst.forEach(System.out::println);
			}
			case 7 ->{
				System.out.println("Thank you fro visting.......");
				sc.close();
				pservice.closeMyConnetion();
				
			}
			}
			
		}
		while(choice!=7) ;
			
		}
			
	}


