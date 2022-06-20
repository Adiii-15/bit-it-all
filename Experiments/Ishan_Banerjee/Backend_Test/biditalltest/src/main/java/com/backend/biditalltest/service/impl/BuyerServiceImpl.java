package com.backend.biditalltest.service.impl;

import com.backend.biditalltest.exception.ResourceNotFoundException;
import com.backend.biditalltest.model.Buyer;
import com.backend.biditalltest.repository.BuyerRepository;
import com.backend.biditalltest.service.BuyerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService {

    private BuyerRepository buyerRepository;

    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer getBuyerByID(Long id) {
        return buyerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Buyer", "Id", id));
    }
}
