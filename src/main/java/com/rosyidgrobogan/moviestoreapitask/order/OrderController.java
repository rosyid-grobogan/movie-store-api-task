package com.rosyidgrobogan.moviestoreapitask.order;

import com.rosyidgrobogan.moviestoreapitask.helpers.errors.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController
{
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderRes> createOrder(
            @RequestBody OrderReq req
    ){
        try {
            OrderRes data = orderService.createOrder(req);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (RuntimeException e){
            throw new ApiRequestException(e.getMessage());
        }
    }
}
