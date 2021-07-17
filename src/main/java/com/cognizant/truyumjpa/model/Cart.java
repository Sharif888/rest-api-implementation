package com.cognizant.truyumjpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
 
@Entity

public class Cart {
	@ManyToMany
	private List<MenuItem> menuItemList = new ArrayList<>();
	private double total;
	@Id
	private int id;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(List<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
