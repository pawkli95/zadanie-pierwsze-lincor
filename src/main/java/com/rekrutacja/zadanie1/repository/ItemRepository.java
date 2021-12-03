package com.rekrutacja.zadanie1.repository;

import com.rekrutacja.zadanie1.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface ItemRepository extends JpaRepository<Item, UUID> {

}
