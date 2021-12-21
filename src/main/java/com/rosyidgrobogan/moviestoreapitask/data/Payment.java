package com.rosyidgrobogan.moviestoreapitask.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payments")
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String holderName;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String numberBank;

    @Column(nullable = false)
    private String invoiceOrder;

    @Column(nullable = false)
    private Double totalPrice;
}
