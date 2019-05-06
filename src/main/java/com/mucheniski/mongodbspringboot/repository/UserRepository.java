package com.mucheniski.mongodbspringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mucheniski.mongodbspringboot.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
