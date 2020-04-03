package com.omni.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omni.ecom.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
