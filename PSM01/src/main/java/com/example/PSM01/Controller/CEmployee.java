package com.example.PSM01.Controller;

import com.example.PSM01.Model.Employee;
import com.example.PSM01.Repository.IEmployee;
import com.example.PSM01.Service.SEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class CEmployee {

    @Autowired
    private SEmployee s;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee e){
        return s.saveEmployee(e);
    }

    @GetMapping("/listrol")
    public List<Employee> listRolAndEmployee(){
        return s.listNameEmployeeAndRole();
    }
}
