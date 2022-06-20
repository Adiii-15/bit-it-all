package com.isu.cs309.biditall.service.impl;


import com.isu.cs309.biditall.exception.ResourceNotFoundException;
import com.isu.cs309.biditall.model.Item;
import com.isu.cs309.biditall.repository.ItemRepository;
import com.isu.cs309.biditall.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private  ItemRepository itemrepository;

    public ItemServiceImpl(ItemRepository itemrepository){
        this.itemrepository=itemrepository;
    }

    @Override
    public Item saveItem(Item item){
        return itemrepository.save(item);
    }


    @Override
    public List<Item> getAllItems(){
        return itemrepository.findAll();
    }

    @Override
    public Item getItemByID(Long id){
        return itemrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "Id", id));
    }

    @Override
    public Long deleteItem(Long id){
        itemrepository.deleteById(id);
        return id;
    }

    @Override
    public List<Item> getNItems(Long n) {
        return itemrepository.getNItems(n);
    }

    @Override
    public Double getCurrentItemPrice(Long id) {
        return itemrepository.getCurrentPrice(id);
    }
}