package com.demo.tests;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;

public class TestGetMyUser {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Product p1 = session.get(Product.class, 1);
		Product p2 = session.get(Product.class,2);
		
	
		
		tr.commit();
		
		System.out.println(p1);
		System.out.println(p2);
		session.close();
		sf.close();

	}

}
