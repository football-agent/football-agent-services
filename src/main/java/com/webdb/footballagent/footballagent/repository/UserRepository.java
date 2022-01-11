package com.webdb.footballagent.footballagent.repository;

import com.webdb.footballagent.footballagent.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
