package com.bhagya.SpringBootWebProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdServices {
	
	@Autowired
	ProdRepo repo;
//	List<Product> products=new ArrayList<>(Arrays.asList(
//			new Product(101,"Mobile",20000),
//			new Product(102,"Laptop",80000),
//			new Product(103,"cycle",10000))
//	);
	
	
	public List<Product> getAllProducts() {
//		return products;
		return repo.findAll();
		
	}
	
	public Product getProdById(int prodId) {
//		return products.stream().filter(prod->prod.getId()==prodId).findFirst().get();
		return repo.findById(prodId).orElse(new Product());
	}
	
	public void addProd(Product prod) {
//		products.add(prod);
		repo.save(prod);
	}
	
	public void updateProd(Product prod) {
//		int index=0;
//		for(int i=0;i<products.size();i++) {
//			if(products.get(i).getId()==prod.getId())
//				index=i;
//				products.set(index, prod);
//		}
		repo.save(prod);
	}
	
	public void deleteProd(int prodId) {
//		int index=0;
//		for(int i=0;i<products.size();i++)
//			if(products.get(i).getId()==prodId)
//				index=i;
//		products.remove(index);
		repo.deleteById(prodId);
	}
	
	




}
