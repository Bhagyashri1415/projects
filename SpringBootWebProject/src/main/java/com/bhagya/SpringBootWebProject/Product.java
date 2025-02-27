package com.bhagya.SpringBootWebProject;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Component
@Entity
public class Product {
    @Id
	private int prodId;
	private String prodName;
	private int prodCost;
	
	Product(){
		
	}
	
	public Product(int prodId,String prodname,int prodCost){
		this.prodId=prodId;
		this.prodName=prodname;
		this.prodCost=prodCost;
	}
	
	public void setId(int prodId) {
		this.prodId=prodId;
	}
	public void setName(String prodName) {
		this.prodName=prodName;
	}public void setCost(int prodCost) {
		this.prodCost=prodCost;
	}
	
	public int getId() {
		return prodId;
	}public String getName() {
		return prodName;
	}public int getCost() {
		return prodCost;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodCost=" + prodCost + "]";
	}
	
	

}
