package com.example.PSM01.Repository;

import com.example.PSM01.Model.Role;
import org.springframework.data.repository.CrudRepository;


public interface IRole extends CrudRepository<Role, Long> {

    //Method exists role name
    boolean existsByNameRole(String nameRole);

}
