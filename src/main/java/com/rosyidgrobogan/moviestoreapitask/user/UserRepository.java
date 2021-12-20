package com.rosyidgrobogan.moviestoreapitask.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
    extends JpaRepository<User, Long>
{
    @Query(value = "SELECT EXISTS(SELECT * FROM users WHERE email= :email) ", nativeQuery = true)
    Boolean isEmailTaken(@Param("email") String email);
}
