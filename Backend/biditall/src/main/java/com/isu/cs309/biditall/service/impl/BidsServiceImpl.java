package com.isu.cs309.biditall.service.impl;

import com.isu.cs309.biditall.exception.ResourceNotFoundException;
import com.isu.cs309.biditall.model.Bids;
import com.isu.cs309.biditall.repository.BidsRepository;
import com.isu.cs309.biditall.service.BidsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidsServiceImpl implements BidsService {

    private BidsRepository bidsRepository;

    public BidsServiceImpl(BidsRepository bidsRepository){
        this.bidsRepository=bidsRepository;
    }

    @Override
    public Bids saveBids(Bids bids){
        return bidsRepository.save(bids);
    }

    @Override
    public List<Bids> getAllBids(){
        return bidsRepository.findAll();
    }

    @Override
    public Bids deleteBid(Long bid_id){
        Bids bid = getBidById(bid_id);
        if(bid_id != null)
            bidsRepository.delete(bid);
        return bid;
    }

    @Override
    public Bids getBidById(Long bid_id){
        return bidsRepository.findById(bid_id).orElseThrow(() -> new ResourceNotFoundException("Transaction", "Id", bid_id));
    }

    @Override
    public Bids updateBid(Bids bids) {
        return bidsRepository.save(bids);
    }

}
