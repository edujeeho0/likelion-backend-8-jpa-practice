package com.example.jpapractice.shop.repo;

import com.example.jpapractice.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {}
