package com.webdb.footballagent.footballagent.repository;

import com.webdb.footballagent.footballagent.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findRoleByName(String name);
}
