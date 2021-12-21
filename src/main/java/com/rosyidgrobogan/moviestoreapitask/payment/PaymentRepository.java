package com.rosyidgrobogan.moviestoreapitask.payment;

import com.rosyidgrobogan.moviestoreapitask.data.Order;
import com.rosyidgrobogan.moviestoreapitask.data.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository
    extends JpaRepository<Payment, Long>
{
        @Query(value = "SELECT EXISTS(SELECT * FROM orders WHERE invoice_order= :invoiceOrder) ", nativeQuery = true)
//    Boolean isEmailTaken(@Param("email") String email);
    boolean existsByInvoiceOrder(@Param("invoiceOrder") String invoiceOrder);

    @Query(value = "INSERT INTO purchases (user_id, movie_id) VALUES (:userId, :movieId)", nativeQuery = true)
    void createPurchase(@Param("userId") Long userId, @Param("movieId") Long movieId);

    @Query(value = "SELECT * FROM orders WHERE invoice_order= :invoiceOrder", nativeQuery = true)
    Order getOrder(@Param("invoiceOrder") String invoiceOrder);
}
