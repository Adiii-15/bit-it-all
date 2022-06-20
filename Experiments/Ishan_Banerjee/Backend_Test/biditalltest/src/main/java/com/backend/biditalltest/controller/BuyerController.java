package com.backend.biditalltest.controller;

import com.backend.biditalltest.model.Buyer;
import com.backend.biditalltest.service.BuyerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buyers")
public class BuyerController {
    private BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    // Build create buyer REST API

    @PostMapping
    public ResponseEntity<Buyer> saveBuyer(@RequestBody Buyer buyer)
    {
        return new ResponseEntity<Buyer>(buyerService.saveBuyer(buyer), HttpStatus.CREATED);
    }

    // Build get all buyers REST API
    @GetMapping
    public List<Buyer> getAllBuyers()
    {
        return buyerService.getAllBuyers();
    }

    // Build get buyer by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable("id") Long buyerId){
        return new ResponseEntity<Buyer>(buyerService.getBuyerByID(buyerId), HttpStatus.OK);
    }
}
