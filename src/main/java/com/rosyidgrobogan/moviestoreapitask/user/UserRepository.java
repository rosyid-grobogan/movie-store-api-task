package com.rosyidgrobogan.moviestoreapitask.user;

import com.rosyidgrobogan.moviestoreapitask.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
    extends JpaRepository<User, Long>
{
    boolean existsByEmail(String email);
    Optional<User> findUserByEmail(String email);
    User findByUsername(String username);
    User findUseryById(Long userId);
}
