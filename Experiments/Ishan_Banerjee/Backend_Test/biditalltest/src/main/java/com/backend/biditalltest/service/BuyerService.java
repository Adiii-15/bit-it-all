package com.backend.biditalltest.service;

import com.backend.biditalltest.model.Buyer;

import java.util.List;

public interface BuyerService {

    Buyer saveBuyer(Buyer buyer);

    List<Buyer> getAllBuyers();

    Buyer getBuyerByID(Long id);
}
