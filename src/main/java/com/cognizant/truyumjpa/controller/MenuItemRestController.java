package com.cognizant.truyumjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyumjpa.exception.MenuNotFoundException;
import com.cognizant.truyumjpa.model.MenuItem;
import com.cognizant.truyumjpa.service.MenuItemIntf;

@RestController
@RequestMapping("/menu")
public class MenuItemRestController {
		@Autowired
		MenuItemIntf menuItemIntf;
		@GetMapping("/all")
		public ResponseEntity<List<MenuItem>> getAllMenuItem()
		{
			List<MenuItem> menuList = menuItemIntf.getMenuList();
			return new ResponseEntity<List<MenuItem>>(menuList,HttpStatus.OK);
		}
		@PostMapping("/additem")
		public ResponseEntity<MenuItem> saveMenu(@RequestBody  MenuItem menuItem)
		{
			MenuItem addMenu = menuItemIntf.addMenu(menuItem);
			return new ResponseEntity<MenuItem>(addMenu,HttpStatus.OK);
		}
		@GetMapping("/getbyid/{id}")
		public ResponseEntity<MenuItem> getAllMenuById(@PathVariable("id") long id) throws MenuNotFoundException
		{
			MenuItem findMenuById = menuItemIntf.findMenuById(id);
			if(findMenuById == null)
			{
				throw new MenuNotFoundException();
			}
		return new ResponseEntity<MenuItem>(findMenuById,HttpStatus.OK);
		}
}
