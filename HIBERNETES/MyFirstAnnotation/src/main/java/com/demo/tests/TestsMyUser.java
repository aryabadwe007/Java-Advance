package com.demo.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.*;

public class TestsMyUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tr = session.beginTransaction();
		
		MyUser u1 = new MyUser("arya", "aa@gmail.com");
		MyUser u2 = new MyUser("anushka","Aa@gmail.com");
		
		Product p1 = new Product(200,"cheese", 2, 50);
		Product p2 = new Product(201,"butter", 3, 60);

		
		session.save(u1);
		session.save(u2);
		session.save(p1);
		session.save(p2);
		tr.commit();
		session.close();
		sf.close();
	}

}
