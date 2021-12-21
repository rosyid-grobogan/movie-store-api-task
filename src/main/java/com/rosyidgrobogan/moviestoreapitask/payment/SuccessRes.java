package com.rosyidgrobogan.moviestoreapitask.payment;

import com.rosyidgrobogan.moviestoreapitask.data.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessRes
{
    private String code;
    private String message;
    private Payment data;
}
