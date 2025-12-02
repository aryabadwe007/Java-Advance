package com.demo.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;
import com.demo.beans.Product;

public class TestMyUser {

	public static void main(String[] args) {
	
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session session= sf.openSession();
		
		MyUser u1=new MyUser(101,"Aryaa","aryaaa@gmail.com");
		MyUser u2=new MyUser(102,"Aryan","aryan@gmail.com");
		
		
		Product p1=new Product(100,"cheese",3,110);
		Product p2=new Product(102,"butter",5,160);
		
		
		Transaction tr=session.beginTransaction();
		
		session.save(u1);
		session.save(u2);
		session.save(p1);
		session.save(p2);
				
				
		tr.commit();
		session.close();
		sf.close();

	}

}
