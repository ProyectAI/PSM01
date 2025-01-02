package com.example.PSM01.Role.Controller;

import com.example.PSM01.Role.Service.SRole;
import com.example.PSM01.Role.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/role")
public class CRole {

    @Autowired
    private SRole s;

    @PostMapping("/save")
    public String saveRole(@RequestBody Role r){
        return s.saveRole(r);
    }

    @GetMapping("/list")
    public List<Role> listAll(){
        return s.listingRole();
    }


}
