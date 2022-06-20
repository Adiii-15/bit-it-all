package com.isu.cs309.biditall.repository;


import com.isu.cs309.biditall.model.Bids;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidsRepository extends JpaRepository<Bids, Long> {
    
}
