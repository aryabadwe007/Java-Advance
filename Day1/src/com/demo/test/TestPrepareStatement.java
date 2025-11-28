package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPrepareStatement {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.117:3306/dac9?useSSL=false";
			conn=DriverManager.getConnection(url,"dac9", "welcome");
			PreparedStatement pst = conn.prepareStatement("select * from product2");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("pid: " + rs.getInt("pid"));
				System.out.println("pname" + rs.getString("pname"));
				System.out.println("qty" + rs.getInt("qty"));
				System.out.println("price" + rs.getDouble("price"));
			}
			
			PreparedStatement pst2 = conn.prepareStatement("insert into product2 values(?,?,?,?)");
			int pid = 01;
			String pname = "Cheese";
			int qty = 5;
			double price = 35;
			pst2.setInt(1, pid);
			pst2.setString(2, pname);
			pst2.setInt(3, qty);
			pst2.setDouble(4, price);
			
			
			PreparedStatement pst3 = conn.prepareStatement("insert into product2 values(?,?,?,?)");
			int pid1 = 02;
			String pname1 = "Pattice";
			int qty1 = 2;
			double price1 = 25;
			pst3.setInt(1, pid1);
			pst3.setString(2, pname1);
			pst3.setInt(3, qty1);
			pst3.setDouble(4, price1);
			
			int n=pst2.executeUpdate();
			n= pst3.executeUpdate();
			if(n>0) {
				System.out.println("Insertion done");
			}else {
				System.out.println("Not Inserted");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}


