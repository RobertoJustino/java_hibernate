package com.hitema.services;

import com.hitema.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role create(Role role);
    Role read(Integer id);
    Role update(Role role);
    Boolean delete(Role id);

}
