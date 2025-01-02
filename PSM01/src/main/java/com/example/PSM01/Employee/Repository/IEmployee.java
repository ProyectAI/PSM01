package com.example.PSM01.Employee.Repository;

import com.example.PSM01.Employee.Model.Employee;
import com.example.PSM01.Role.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IEmployee extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT e.id, e.name_employee, e.email, e.phone, e.role_id, r.name_role " +
            "FROM employee e " +
            "JOIN role r ON e.role_id = r.id", nativeQuery = true)
    List<Employee> nameEmployeeAndNameRole();





}
