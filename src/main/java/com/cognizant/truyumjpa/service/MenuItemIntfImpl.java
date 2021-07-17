package com.cognizant.truyumjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyumjpa.exception.MenuNotFoundException;
import com.cognizant.truyumjpa.model.MenuItem;
import com.cognizant.truyumjpa.repo.MenuItemRepo;
@Service
public class MenuItemIntfImpl implements MenuItemIntf {
	@Autowired
	MenuItemRepo menuItemRepo;
	
	
	
	@Override
	public MenuItem addMenu(MenuItem menuItem) {
		MenuItem save = menuItemRepo.save(menuItem);
		return save;
	}

	@Override
	public List<MenuItem> getMenuList() {
		List<MenuItem> findAll = menuItemRepo.findAll();
		return findAll;
	}

	@Override
	public MenuItem findMenuById(long id) throws MenuNotFoundException {
			Optional<MenuItem> findById = menuItemRepo.findById(id);
			if(findById.isPresent())
			{
				return findById.get();
			}
			throw new MenuNotFoundException();
	}

}
