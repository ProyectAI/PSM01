package com.example.PSM01.Repository;

import com.example.PSM01.Model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmployee extends CrudRepository<Employee, Long> {


    @Query(value = "SELECT e.id, e.name_employee, e.email, e.phone, e.role_id, r.name_role " +
            "FROM employee e " +
            "JOIN role r ON e.role_id = r.id", nativeQuery = true)
    List<Object[]> nameEmployeeAndNameRole();


}
