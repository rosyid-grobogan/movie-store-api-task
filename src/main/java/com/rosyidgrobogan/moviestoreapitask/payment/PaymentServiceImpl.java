package com.rosyidgrobogan.moviestoreapitask.payment;

import com.rosyidgrobogan.moviestoreapitask.data.*;
import com.rosyidgrobogan.moviestoreapitask.purchase.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl
    implements PaymentService
{
    private final PaymentRepository paymentRepository;
    private final PurchaseRepository purchaseRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PurchaseRepository purchaseRepository)
    {
        this.paymentRepository = paymentRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public PaymentRes confirmBank(PaymentReq req)
    {
            Payment payment = new Payment();

            payment.setHolderName(req.getHolderName());
            payment.setBankName(req.getBankName());
            payment.setNumberBank(req.getNumberBank());
            payment.setInvoiceOrder(req.getInvoiceOrder());
            payment.setTotalPrice(req.getTotalPrice());

            paymentRepository.save(payment);

            PaymentRes dataRes = new PaymentRes("200", "success", payment);
            return dataRes;
    }

    @Override
    public PaymentRes confirmPayment(ConfirmReq req)
    {

        Purchase purchase = new Purchase();
        User user = new User();
        user.setId(req.getUserId());

        Movie movie = new Movie();
        movie.setId(req.getMovieId());

        purchase.setUser(user);
        purchase.setMovie(movie);

         purchaseRepository.save(purchase);

         PaymentRes dataRes = new PaymentRes("200", "success", null);
        return dataRes;
    }
}
