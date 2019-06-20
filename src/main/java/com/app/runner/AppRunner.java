package com.app.runner;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repository.ProductRepository;
import com.app.repository.ProductRepository.viewA;
@Component
public class AppRunner implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;
	@Override
	public void run(String... args) throws Exception {
		//1. save method
		
		/*
		 * repo.save(new Product(1,"A",3.6)); repo.save(new Product(2,"B",4.6));
		 * repo.save(new Product(3,"C",5.6)); repo.save(new Product(4,"D",6.6));
		 */
		// Update Call
		//repo.save(new Product(3,"FF",7.8));
		
		//Bulk Insert
		/*
		 * List<Product> prds=Arrays.asList( new Product(101,"AA",33.6), new
		 * Product(102,"BB",44.6), new Product(103,"CC",55.6) ); repo.saveAll(prds);
		 * 
		 * //fetch one row use by ID Optional<Product> p=repo.findById(103);
		 * if(p.isPresent()) { Product pr=p.get(); System.out.println(pr); }else {
		 * System.out.println("Record Not Found"); }
		 * 
		 * // fetch All rows List<Product> list=repo.findAll();
		 * list.forEach(System.out::println);
		 * 
		 * // delete operation repo.deleteById(1);
		 * 
		 * //delete all records one by one repo.deleteAll();
		 * 
		 * //delete all records in batch repo.deleteAllInBatch();
		 */
		
		/*
		 * List<Product> prd=repo.findAll(Sort.by(Direction.DESC, "prodId"));
		 * for(Product p:prd) { System.out.println(p.getProdCode());
		 * System.out.println(p.getProdCost()); System.out.println(p.getProdId());
		 * 
		 * }
		 */
		PageRequest ps=PageRequest.of(0, 2);
		//repo.findAll(ps).forEach(System.out::println);
		
		Product p=new Product();
		p.setProdCost(5.6);
		
		Example<Product> ex= Example.of(p);
		//repo.findAll(ex).forEach(System.out::println);
		//repo.findAll(ex,Sort.by(Direction.DESC,"prodCode")).forEach(System.out::println);
		//repo.findAll(ex,ps).forEach(System.out::println);
		//repo.findAllById(Arrays.asList(2,4,5,8)).forEach(System.out::println);
		//repo.findByProdCost(5.6).forEach(l->System.out.println(l.getProdCode()+":"+l.getProdCost()));
		System.out.println("");
		//repo.findByProdCode("B").forEach(k->System.out.println(k.getProdId()+":"+k.getProdCode()));
		repo.findByProdCode("B", viewA.class).forEach(k->System.out.println(k.getProdCode()+":"+k.getProdCost()));
		
		
		
	}

}
