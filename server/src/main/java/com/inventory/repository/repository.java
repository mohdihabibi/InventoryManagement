package com.inventory.repository;

import com.inventory.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<Item,Long>  {
}
