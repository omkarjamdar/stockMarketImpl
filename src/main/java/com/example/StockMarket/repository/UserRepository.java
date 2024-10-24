package com.example.StockMarket.repository;

import com.example.StockMarket.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    public User findByUsername(String username);
    Optional<User> findByEmail(String email);


}
