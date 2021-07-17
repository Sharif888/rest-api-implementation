package com.cognizant.truyumjpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyumjpa.exception.MenuNotFoundException;
import com.cognizant.truyumjpa.model.MenuItem;
@Component
public interface MenuItemIntf {
	public MenuItem addMenu(MenuItem menuItem);
	public List<MenuItem> getMenuList();
	public MenuItem findMenuById(long id) throws MenuNotFoundException;
	
}
