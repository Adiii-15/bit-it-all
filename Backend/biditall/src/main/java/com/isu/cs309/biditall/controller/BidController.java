package com.isu.cs309.biditall.controller;

import com.isu.cs309.biditall.model.Bids;
import com.isu.cs309.biditall.service.BidsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bid")
public class BidController {

    @Autowired
    BidsService bidsService;

    @PostMapping
    public ResponseEntity<Bids> saveBid(@RequestBody Bids bids){
        if(bids == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bidsService.saveBids(bids), HttpStatus.CREATED);
    }

    @GetMapping({"id"})
    public ResponseEntity<Bids> getBidById(@PathVariable Long id)
    {
        return new ResponseEntity<>(bidsService.getBidById(id),HttpStatus.OK);
    }
//
//    public ResponseEntity<Bids> deleteBids(@PathVariable Long id) {
//        bidsService.deleteBid(id);
//    }

}
