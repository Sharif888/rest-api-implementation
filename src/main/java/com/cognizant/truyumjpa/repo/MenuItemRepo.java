package com.cognizant.truyumjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.truyumjpa.model.MenuItem;

public interface MenuItemRepo  extends JpaRepository<MenuItem, Long>{

}
