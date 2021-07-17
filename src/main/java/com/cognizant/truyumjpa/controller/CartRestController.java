package com.cognizant.truyumjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyumjpa.exception.MenuNotFoundException;
import com.cognizant.truyumjpa.model.Cart;
import com.cognizant.truyumjpa.service.CartIntf;

@RestController
@RequestMapping("/cart")
public class CartRestController {
	@Autowired
	CartIntf cartIntf;
	@PostMapping("/addcart/{userid}/{menuid}")
	public ResponseEntity<Cart> addCart(@PathVariable int userid, @PathVariable long menuid) throws MenuNotFoundException
	{
		Cart addCart = cartIntf.addCart(userid, menuid);
		System.out.println(userid+  "   " + menuid);
		return new ResponseEntity<Cart>(addCart,HttpStatus.OK);
	}
	
	@GetMapping("/getall/{userid}")
	public ResponseEntity<Cart> showCartValues(@PathVariable int userid )
	{
		Cart viewCart = cartIntf.viewCart(userid);
		return new ResponseEntity<Cart>(viewCart,HttpStatus.OK);
	}
	@DeleteMapping("/remove/{userid}/{menuid}")
	public ResponseEntity<Cart> removeFromCart(@PathVariable int userid, @PathVariable long menuid) throws MenuNotFoundException{
		Cart removeCart = cartIntf.removeCart(userid, menuid);
		return new ResponseEntity<Cart>(removeCart,HttpStatus.OK);
	}
}
