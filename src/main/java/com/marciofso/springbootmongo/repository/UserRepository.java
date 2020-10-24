package com.marciofso.springbootmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marciofso.springbootmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
