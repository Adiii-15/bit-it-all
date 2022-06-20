package com.isu.cs309.biditall.service;
import com.isu.cs309.biditall.model.Item;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;



public interface ItemService {

    Item saveItem(Item item);
    Item getItemByID(Long id);
    List<Item> getAllItems();
    Long deleteItem(Long id);
    List<Item> getNItems(Long n);
    Double getCurrentItemPrice(Long id);

    interface FileService {

        public void init();

        public void save(MultipartFile file);

        public Resource load(String filename);

        public void deleteAll();

        public List<Path> loadAll();

    }
}

