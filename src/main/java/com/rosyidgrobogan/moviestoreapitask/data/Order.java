package com.rosyidgrobogan.moviestoreapitask.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String invoiceOrder;

    private Long movieId;

    private Long userId;

    private Double totalPrice;
}
