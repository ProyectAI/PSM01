package com.example.PSM01.Role.Service;


import com.example.PSM01.Role.Model.Role;
import com.example.PSM01.Role.Repository.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SRole {

    @Autowired
    private IRole r;

    //Method for saving roles
    public String saveRole(Role role){
        if(r.existsByNameRole(role.getNameRole())){
            return "El rol: "+ role.getNameRole() +"ya está ingresado";
        }
         r.save(role);
        return "Se guardo correctamente: "+ role.getNameRole();
    }

    //Method for listing roles
    public List<Role> listingRole(){
        return (List<Role>)r.findAll();
    }


}
