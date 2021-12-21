package com.rosyidgrobogan.moviestoreapitask.payment;

import com.rosyidgrobogan.moviestoreapitask.data.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl
    implements PaymentService
{
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository)
    {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentRes confirmationPayment(PaymentReq req)
    {
        Payment payment = new Payment();

        payment.setHolderName(req.getHolderName());
        payment.setBankName(req.getBankName());
        payment.setNumberBank(req.getNumberBank());
        payment.setInvoiceOrder(req.getInvoiceOrder());
        payment.setTotalPrice(req.getTotalPrice());

        paymentRepository.save(payment);
        PaymentRes dataRes = new PaymentRes("201", "success", payment);
        return dataRes;
    }
}
