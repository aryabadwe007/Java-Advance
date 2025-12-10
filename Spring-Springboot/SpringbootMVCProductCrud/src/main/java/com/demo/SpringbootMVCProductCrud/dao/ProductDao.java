package com.demo.SpringbootMVCProductCrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SpringbootMVCProductCrud.beans.Product;

public interface ProductDao extends JpaRepository<Product,Integer> {



}
