package com.rosyidgrobogan.moviestoreapitask.purchase;


import com.rosyidgrobogan.moviestoreapitask.data.Movie;
import com.rosyidgrobogan.moviestoreapitask.order.OrderRepository;
import com.rosyidgrobogan.moviestoreapitask.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl
    implements PurchaseService
{
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(UserRepository userRepository, OrderRepository orderRepository, PurchaseRepository purchaseRepository)
    {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void addPurchase(PurchaseReq req)
    {
//        Purchase purchase = new Purchase();
//
//        purchase.setUserId(req.getUserId());
//        purchase.setMovieId(req.getMovieId());
//
//        purchaseRepository.save(purchase);
    }

    @Override
    public MoviesPurchasedRes getAll(Long userId)
    {
        List<Object> movies = purchaseRepository.getMovies(userId);
        MoviesPurchasedRes dataRes = new MoviesPurchasedRes("200", "success", movies);
        return dataRes;
    }
}
