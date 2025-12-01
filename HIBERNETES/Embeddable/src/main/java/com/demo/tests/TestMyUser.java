package com.demo.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.*;
public class TestMyUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tr = session.beginTransaction();
		System.out.println("before get");
		
		Address a1=new Address(12,"S.B.Road","Pune","411016");
		MyUser u1 = new MyUser("Arya", "213456789", a1);
		MyUser u2 = new MyUser("Anushka", "123456789", a1);
		
		/* MyUser u1 = session.get(MyUser.class, 12); */
		/* System.out.println("after get"); */
		/* System.out.println(u1); */
		
		
		session.save(u1);
		session.save(u2);
		tr.commit();
		session.close();
		sf.close();
	}	

}
