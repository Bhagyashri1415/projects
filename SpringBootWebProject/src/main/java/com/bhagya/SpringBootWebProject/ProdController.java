package com.bhagya.SpringBootWebProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdController {
	
	@Autowired
	ProdServices serviices;
	
//	@RequestMapping("/product")
	@GetMapping("/product")
	public List<Product> getAllProd(){
		return serviices.getAllProducts();
	}
	
	@GetMapping("/product/{prodId}")
	public Product getById(@PathVariable int prodId) {
		return serviices.getProdById(prodId);
	}
	
	@PostMapping("/product")   //to add 
	public void addProd(@RequestBody  Product prod) {
		serviices.addProd(prod);
	}
	
	@PutMapping("/product")
	public void updateProd(@RequestBody Product prod) {
		serviices.updateProd(prod);
	}
	
	
	@DeleteMapping("/product/{prodId}")
	public void deleteProd(@PathVariable @RequestBody int prodId) {
		serviices.deleteProd(prodId);
	}




}
