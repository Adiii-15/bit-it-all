package com.isu.cs309.biditall.controller;

import com.isu.cs309.biditall.configure.SpringFoxConfig;
import com.isu.cs309.biditall.model.Payment;
import com.isu.cs309.biditall.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Payment-Handling-Controller", tags = {SpringFoxConfig.PAYMENT_DESCRIPTION_TAG})
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @ApiOperation(value = "Stores a new payment option in the system.", response = Payment.class, tags = "savePaymentMethod")
    @PostMapping
    public ResponseEntity<Payment> savePaymentMethod(@RequestBody Payment payment){
        return new ResponseEntity<>(paymentService.savePaymentMethod(payment), HttpStatus.OK);
    }

}
