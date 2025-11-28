package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	static Connection conn;
	static PreparedStatement insprod,findById,deleteById,updateById,findprod,sortByPrice;
	static {
		try {
			conn=DBUtil.getMyConnection();
			insprod=conn.prepareStatement("insert into product2 values(?,?,?,?,?)");
			findprod=conn.prepareStatement("select * feom product2");
			findById=conn.prepareStatement("select * from product2 where pid=?");
			deleteById=conn.prepareStatement("selete from product2 where pid=?");
			updateById=conn.prepareStatement("update product2 set qty=? ,price=? where pid=?");
			sortByPrice=conn.prepareStatement("select * from product2 order by price");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean save(Product p) {
		try {
			insprod.setInt(1, p.getPid());
			insprod.setString(2,p.getPname());
			insprod.setInt(3, p.getQty());
			insprod.setDouble(4, p.getPrice());
			insprod.setDate(5, java.sql.Date.valueOf(p.getLdt()));
			int n=insprod.executeUpdate();
			return n>0;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	
	
	@Override
	public List<Product> findAllProducts() {
		List<Product> plist=new ArrayList<>();
		try {
		ResultSet rs=findprod.executeQuery();
		while(rs.next()) {
			if(rs.getDate(5)!=null) {
			   plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate()));
			}else{
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null));
			}
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(plist.size()>0) {
			return plist;
		}
		else {
			return null;
		}
		
	}
	@Override
	public boolean removeByID(int id) {

		try {
			deleteById.setInt(1,id);
			int n=deleteById.executeUpdate();
			if(n>0) {
				return true;
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
			
		
		return false;
	}

	@Override
	public boolean updateById(int id, int qty, double price) {
		try {
			updateById.setInt(1, id);
			updateById.setInt(2, qty);
			updateById.setDouble(3, price);
			int n=updateById.executeUpdate();
			if(n>0) {
				return true;
				
			}
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public Product findById(int id) {
		Product p=null;
		try {
	
			findById.setInt(1,id);
			ResultSet rs=findById.executeQuery();
			
			if(rs.next()) {
				if(rs.getDate(5)!=null) {
					p=new Product(rs.getInt(1),rs.getString(3),rs.getInt(2),rs.getDouble(4),rs.getDate(5).toLocalDate());
				}else {
					p=new Product(rs.getInt(1),rs.getString(3),rs.getInt(2),rs.getDouble(4),null);
				}
			}
		}catch(SQLException e) {
				e.printStackTrace();
				
			}
		

		return p;
	}



	@Override
	public List<Product> arrangeByPrice() {
		List <Product> plist= new ArrayList<>();
		try {
			ResultSet rs=sortByPrice.executeQuery();
			if(rs.next()) {
				if(rs.getDate(5)!=null) {
					plist.add(new Product(rs.getInt(1),rs.getString(3),rs.getInt(2),rs.getDouble(4),rs.getDate(5).toLocalDate()));
				}else {
					plist.add(new Product(rs.getInt(1),rs.getString(3),rs.getInt(2),rs.getDouble(4),null));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(plist.size()>0) {
			return plist;
			
		}
		return null;
	}



	@Override
	public void closeMyConnection() {
		DBUtil.closeConnection();
	}
	
	

}

