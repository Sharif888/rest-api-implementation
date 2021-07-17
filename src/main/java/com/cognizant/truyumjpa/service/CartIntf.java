package com.cognizant.truyumjpa.service;

import org.springframework.stereotype.Component;

import com.cognizant.truyumjpa.exception.CartNotFoundException;
import com.cognizant.truyumjpa.exception.MenuNotFoundException;
import com.cognizant.truyumjpa.model.Cart;
@Component
public interface CartIntf {
		public Cart addCart(int userid, long menuid) throws MenuNotFoundException;
		public Cart viewCart(int userid) throws CartNotFoundException;
		public Cart removeCart(int userid, long menuid) throws MenuNotFoundException;
}
