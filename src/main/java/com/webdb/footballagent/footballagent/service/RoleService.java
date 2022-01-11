package com.webdb.footballagent.footballagent.service;

import com.webdb.footballagent.footballagent.model.Role;
import com.webdb.footballagent.footballagent.repository.RoleRepository;
import org.springframework.stereotype.Service;


@Service(value = "roleService")
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name) {
        Role role = roleRepository.findRoleByName(name);
        return role;
    }

}
