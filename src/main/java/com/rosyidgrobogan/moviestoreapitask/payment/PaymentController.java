package com.rosyidgrobogan.moviestoreapitask.payment;

import com.rosyidgrobogan.moviestoreapitask.data.Purchase;
import com.rosyidgrobogan.moviestoreapitask.helpers.errors.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
public class PaymentController
{
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentRes> confirmBank(
            @RequestBody PaymentReq req
    ){
        try {
            PaymentRes data = paymentService.confirmBank(req);
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (RuntimeException e){
            throw new ApiRequestException(e.getMessage());
        }
    }

    @PostMapping("/confirm")
    public ResponseEntity<PaymentRes> confirmPayment(
            @RequestBody ConfirmReq req
    ){
        try {
            PaymentRes data = paymentService.confirmPayment(req);
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (RuntimeException e){
            throw new ApiRequestException(e.getMessage());
        }
    }
}
