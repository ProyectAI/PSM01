package com.example.PSM01.Role.Repository;

import com.example.PSM01.Role.Model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface IRole extends CrudRepository<Role, Long> {

    //Method exists role name
    boolean existsByNameRole(String nameRole);
    Optional<Role> findByNameRole(String nameRole);
}
