package com.isu.cs309.biditall.service.impl;

import com.isu.cs309.biditall.model.Payment;
import com.isu.cs309.biditall.repository.PaymentRepository;
import com.isu.cs309.biditall.service.PaymentService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    private PasswordEncoder passwordEncoder;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Payment savePaymentMethod(Payment payment) {
        String encodedCardNumber = passwordEncoder.encode(payment.getCardNumber());
        String encodedCVV = passwordEncoder.encode(payment.getCardCVV());
        String encodedCardIssuer = passwordEncoder.encode(payment.getCardIssuer());
        String encodedBankName = passwordEncoder.encode(payment.getBankName());
        payment.setCardNumber(encodedCardNumber);
        payment.setCardCVV(encodedCVV);
        payment.setCardIssuer(encodedCardIssuer);
        payment.setBankName(encodedBankName);
        return paymentRepository.save(payment);
    }
}
