package com.cognizant.truyumjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyumjpa.exception.CartNotFoundException;
import com.cognizant.truyumjpa.exception.MenuNotFoundException;
import com.cognizant.truyumjpa.model.Cart;
import com.cognizant.truyumjpa.model.MenuItem;
import com.cognizant.truyumjpa.repo.CartRepo;
import com.cognizant.truyumjpa.repo.MenuItemRepo;

@Service
public class CartIntfImpl implements CartIntf {
	@Autowired
	CartRepo cartRepo;
	@Autowired
	MenuItemRepo menuItemRepo;

	@Override
	public Cart addCart(int userid, long menuid) throws MenuNotFoundException {
		Optional<Cart> cart = cartRepo.findById(userid);

		Optional<MenuItem> menuItem = menuItemRepo.findById(menuid);
		if (menuItem.isPresent()) {
			if (cart.isPresent()) {
				cart.get().getMenuItemList().add(menuItem.get());
				cart.get().setTotal(cart.get().getTotal() + menuItem.get().getPrice());
				Cart save = cartRepo.save(cart.get());
				return save;
			} else {

				Cart newCart = new Cart();
				newCart.getMenuItemList().add(menuItem.get());
				newCart.setTotal(menuItem.get().getPrice());
				newCart.setId(userid);
				Cart save = cartRepo.save(newCart);
				return save;
			}
		} else {
			throw new MenuNotFoundException();
		}
	}

	@Override
	public Cart viewCart(int userid) throws CartNotFoundException {
		Optional<Cart> cart = cartRepo.findById(userid);
		if (cart.isPresent()) {
			return cart.get();
		}
		throw new CartNotFoundException();
	}

	@Override
	public Cart removeCart(int userid, long menuid) throws MenuNotFoundException {
		Optional<Cart> cart = cartRepo.findById(userid);
		if (cart.isPresent()) {

			Optional<MenuItem> menuItem = menuItemRepo.findById(menuid);
			if(cart.get().getMenuItemList().contains(menuItem.get())) {
				List<MenuItem> menuItemList = cart.get().getMenuItemList();
				if (menuItem.isPresent()) {
					menuItemList.remove(menuItem.get());
					cart.get().setTotal(cart.get().getTotal() - menuItem.get().getPrice());
					Cart save = cartRepo.save(cart.get());

					return save;
				} else {
					throw new MenuNotFoundException();
				}
			}
		}
		throw new CartNotFoundException();
	}

}
