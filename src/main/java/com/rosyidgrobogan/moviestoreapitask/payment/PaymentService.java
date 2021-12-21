package com.rosyidgrobogan.moviestoreapitask.payment;

import com.rosyidgrobogan.moviestoreapitask.data.Purchase;

public interface PaymentService
{
    PaymentRes confirmBank(PaymentReq req);
    PaymentRes confirmPayment(ConfirmReq req);
}
