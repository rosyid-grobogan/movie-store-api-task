package com.rosyidgrobogan.moviestoreapitask.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmReq
{
    private String invoiceOrder;
    private Long userId;
    private Long movieId;
}
