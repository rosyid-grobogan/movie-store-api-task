package com.rosyidgrobogan.moviestoreapitask.order;

import com.rosyidgrobogan.moviestoreapitask.data.Order;
import com.rosyidgrobogan.moviestoreapitask.helpers.utils.GenerateRandomChars;
import com.rosyidgrobogan.moviestoreapitask.movie.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl
    implements OrderService
{
    private final OrderRepository orderRepository;


    public OrderServiceImpl(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderRes createOrder(OrderReq req)
    {
        Order order = new Order();
        order.setUserId(req.getUserId());
        order.setMovieId(req.getMovieId());

        // processing in backend
        String invoice = GenerateRandomChars.generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 6);
        Double totalPrice = orderRepository.getPrice(req.getMovieId());

        order.setInvoiceOrder("INV"+invoice);
        order.setTotalPrice(totalPrice);

        orderRepository.save(order);

        OrderRes dataRes = new OrderRes("201", "success", order);
        return dataRes;
    }
}
