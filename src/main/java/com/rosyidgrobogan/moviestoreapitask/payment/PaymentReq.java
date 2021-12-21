package com.rosyidgrobogan.moviestoreapitask.payment;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class PaymentReq
{
    @NotBlank
    private String holderName;

    @NotBlank
    private String bankName;

    @NotBlank
    private String numberBank;

    @NotBlank
    private String invoiceOrder;

    @NotBlank
    private Double totalPrice;
}
