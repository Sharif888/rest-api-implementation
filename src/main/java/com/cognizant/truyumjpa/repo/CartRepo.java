package com.cognizant.truyumjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.truyumjpa.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

}
