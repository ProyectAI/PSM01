package com.example.PSM01.Service;

import com.example.PSM01.Model.Employee;
import com.example.PSM01.Repository.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SEmployee {

    @Autowired
    private IEmployee i;

    //Method for saving employee data
    public Employee saveEmployee(Employee employee){
        return i.save(employee);
    }

    public List<Employee> listNameEmployeeAndRole(){
        return (List<Employee>)i.nameEmployeeAndNameRole();
    }


}
