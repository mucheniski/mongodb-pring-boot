package com.mucheniski.mongodbspringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mucheniski.mongodbspringboot.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
