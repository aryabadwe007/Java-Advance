package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateStatement {		
	public static void main(String[] args) {
			Connection conn=null;
			try {	
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.117:3306/dac9?useSSL=false";
			
			conn=DriverManager.getConnection(url,"dac9","welcome");
			if(conn!=null) {
				System.out.println("connection done");
			}else {
				System.out.println("connection not done");
			}
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select *  from product1");
			while(rs.next()) {
				System.out.println("proid" +rs.getInt(1));     
				System.out.println("descrip" +rs.getString(2));

				System.out.println("price" +rs.getDouble(3));

				System.out.println("-----------------------------------");
			}
			
			int pid=143;
			String descrip="abcd";
			double price=6789;

			String query="insert into product1 values("+pid+" ,'"+descrip+" ,'"+price+"')";
			System.out.println(query);
			
			
			}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		}
}





