package com.isu.cs309.biditall.service;

import com.isu.cs309.biditall.model.Bids;

import java.util.List;

public interface BidsService {

    Bids saveBids(Bids bids);

    List<Bids> getAllBids();

    Bids deleteBid(Long bid_id);

    Bids getBidById(Long bid_id);

    Bids updateBid(Bids bids);
}
