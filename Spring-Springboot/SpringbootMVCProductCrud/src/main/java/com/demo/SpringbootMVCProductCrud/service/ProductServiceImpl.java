package com.demo.SpringbootMVCProductCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringbootMVCProductCrud.beans.Product;
import com.demo.SpringbootMVCProductCrud.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	
	ProductDao pdao;
	
	@Override
	public List<Product> findAllProducts() {
		
		return pdao.findAll();
	}

	@Override
	public void addnewProduct(Product prod) {
		// TODO Auto-generated method stub
		 pdao.save(prod);
	}

	@Override
	public Product getById(int pid) {  //Edit
		// TODO Auto-generated method stub
		Optional<Product> op = pdao.findById(pid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public void updateProduct(Product prod) {
		// TODO Auto-generated method stub
		Optional<Product> op = pdao.findById(prod.getPid());
		if(op.isPresent()) {
			Product p = op.get() ;
			p.setPname(prod.getPname());
			p.setPrice(prod.getPrice());
			p.setQty(prod.getQty());
			pdao.save(p);
		}
		
	}

	@Override
	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub
		Optional<Product> op=pdao.findById(pid);
		if(op.isPresent()) {
			Product p = op.get();
			pdao.delete(p);
		}
	}
	
	
	
	

}
