package com.rosyidgrobogan.moviestoreapitask.purchase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesPurchasedRes
{
    private String code;
    private String message;
    private List<Object> data;
}
