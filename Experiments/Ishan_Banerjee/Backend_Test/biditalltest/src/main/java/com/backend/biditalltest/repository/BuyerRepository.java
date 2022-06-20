package com.backend.biditalltest.repository;

import com.backend.biditalltest.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
