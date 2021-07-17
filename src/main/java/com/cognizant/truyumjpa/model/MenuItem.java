package com.cognizant.truyumjpa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity

public class MenuItem {
	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Min(1)
	@Max(100)
	private long id;
	@Size(min = 5, max = 50)
	private String name;
	@Max(110000)
	private float price;
	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;

	public MenuItem(long id, String name, float price, boolean active, Date dateOfLaunch, 
			String category, boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public String toString() {
		return "Id = " + id + "\nName = " + name + "\nPrice = " + price + "\nActive = " + active +
				"\nDate Of Launch = " + dateOfLaunch + "\nCategory = " + category + 
				"\nFree Delivery = " + freeDelivery + "\n***************************************";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
