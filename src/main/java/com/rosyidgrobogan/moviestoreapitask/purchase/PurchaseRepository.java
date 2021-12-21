package com.rosyidgrobogan.moviestoreapitask.purchase;

import com.rosyidgrobogan.moviestoreapitask.data.Movie;
import com.rosyidgrobogan.moviestoreapitask.data.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository
    extends JpaRepository<Purchase, Long>
{
    @Query(value = "SELECT movies.id, movies.genre, movies.poster, movies.price, movies.synopsis, movies.title, movies.trailer FROM users JOIN purchases on (users.id=purchases.user_id) JOIN movies on (movies.id=purchases.movie_id) WHERE user_id= :userId ", nativeQuery = true)
//    @Query(value = "SELECT * FROM users JOIN purchases on (users.id=purchases.user_id) JOIN movies on (movies.id=purchases.movie_id) WHERE user_id= :userId ", nativeQuery = true)
    List<Object> getMovies(@Param("userId") Long userId);
}
