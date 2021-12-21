package com.rosyidgrobogan.moviestoreapitask.order;

import com.rosyidgrobogan.moviestoreapitask.data.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRes
{
    private String code;
    private String message;
    private Order data;
}
