package com.isu.cs309.biditall.repository;

import com.isu.cs309.biditall.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
