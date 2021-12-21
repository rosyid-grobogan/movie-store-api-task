package com.rosyidgrobogan.moviestoreapitask.order;

import com.rosyidgrobogan.moviestoreapitask.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository
    extends JpaRepository<Order, Long>
{
    @Query(value = "SELECT price FROM movies WHERE id= :movieId", nativeQuery = true)
    Double getPrice(@Param("movieId") Long movieId);
}
