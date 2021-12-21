package com.rosyidgrobogan.moviestoreapitask.purchase;


public interface PurchaseService
{
    void addPurchase(PurchaseReq req);

    MoviesPurchasedRes getAll(Long userId);
}
