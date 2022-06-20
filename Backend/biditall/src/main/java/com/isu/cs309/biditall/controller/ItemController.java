package com.isu.cs309.biditall.controller;

import com.isu.cs309.biditall.extension.ItemModule;
import com.isu.cs309.biditall.model.Item;
import com.isu.cs309.biditall.service.impl.ItemServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "Item Controller")
@RestController
@RequestMapping("/api/item")
public class ItemController {

    private ItemServiceImpl item;

    public ItemController(ItemServiceImpl itemServices)
    {
        this.item = itemServices;
    }

    /*
     * Save user that is being requested
     */
    @ApiOperation(value = "Add requested items by the user", response = Item.class, tags = "item")
    @PostMapping
    public void addItems(@RequestBody Item items)
    {
        item.saveItem(items);
    }

    /**
     * Request List of players
     * @return
     */

    //example of a get request to view the list of players on the database
    @ApiOperation(value = "Get item list of given user", response = Item.class, tags = "item")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/listAll")
    public List<Item> itemList() {
        return item.getAllItems();
    }

    @ApiOperation(value = "Get specific item by itemID", response = Item.class, tags = "item")
    @GetMapping("{id}")
    public Item getItemByIDs(@PathVariable("id") Long userId)
    {
        return item.getItemByID(userId);
    }

    @GetMapping("/list/{number}")
    public ResponseEntity<List<ItemModule>> getFirstNItems(@PathVariable("number") Long number){
        List<Item> itemList = item.getNItems(number);
        List<ItemModule> returnList = new ArrayList<>();
        for(Item ele : itemList){
            ItemModule tmp = new ItemModule(ele.getItemName()
                    ,ele.getDescription(),ele.getEndDate(),ele.getPostedDate(),
                    0.0,
                    ele.getBuyNowPrice(),ele.getBidPrice());  //item.getCurrentItemPrice(ele.getItemId())
            returnList.add(tmp);
        }
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }


    @ApiOperation(value = "Delete item that user does not need by itemID", response = Item.class, tags = "item")
    @DeleteMapping("{id}")
    public Long deleteItems(@PathVariable("id") Long userId)
    {
        return item.deleteItem(userId);
    }
}
