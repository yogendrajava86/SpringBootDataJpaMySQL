package com.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	//get All records
	List<Product> findAll();
	//List<Product> findByProdCost(Double prodCost);
	interface viewA{
		String getProdCode();
		Double getProdCost();
	}
	interface viewB{
		Integer getProdId();
		String getProdCode();
		
	}
	//List<viewA> findByProdCost(Double prodCost);
	//List<viewB> findByProdCode(String prodCode);
	
	<T>List<T> findByProdCode(String prodCode,Class<T> cls);
	
	
	

}
