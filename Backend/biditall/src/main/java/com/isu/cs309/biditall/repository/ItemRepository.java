package com.isu.cs309.biditall.repository;

import com.isu.cs309.biditall.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>  {

    @Query(value="SELECT * FROM items ORDER BY item_id LIMIT ?1", nativeQuery = true)
    List<Item> getNItems(Long n);

    @Query(value = "SELECT b.current_price " +
            "FROM bids b JOIN items i ON i.item_id = b.item_id" +
            "WHERE i.item_id = ?1", nativeQuery = true)
    Double getCurrentPrice(Long id);
}
