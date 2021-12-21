package com.rosyidgrobogan.moviestoreapitask.purchase;


import com.rosyidgrobogan.moviestoreapitask.helpers.errors.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchases")
@PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
public class PurchaseController
{
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService)
    {
        this.purchaseService = purchaseService;
    }

//    @PostMapping
//    public ResponseEntity<> addPurchase(@RequestBody @Valid PurchaseReq req)
//    {
//        try {
//            purchaseService.addPurchase(req);
//        } catch (RuntimeException e){
//            throw new ApiRequestException(e.getMessage());
//        }
//    }
//
    @GetMapping("/{userId}")
    public ResponseEntity<MoviesPurchasedRes> getMovies(@PathVariable("userId") Long userId )
    {
        try {
            MoviesPurchasedRes data = purchaseService.getAll(userId);
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (RuntimeException e){
            throw new ApiRequestException(e.getMessage());
        }
    }
}
