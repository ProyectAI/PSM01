package com.example.PSM01.Role.Model;


import com.example.PSM01.DTO.EmployeeDto.RoleDto.DtoRole;
import com.example.PSM01.Employee.Model.Employee;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_role", unique = true)
    private String nameRole;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Employee> employee;


    //Constructor
    public Role(Long id, String nameRole, List<Employee> employee) {
        this.id = id;
        this.nameRole = nameRole;
        this.employee = employee;
    }

    public Role() {
    }

    public Role(DtoRole role) {
        this.nameRole= role.nameRole();
    }



    //Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        employee.forEach(e->e.setRole(this));
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nameRole='" + nameRole + '\'' +
                ", employee=" + employee +
                '}';
    }


    public Role updateDatos(DtoRole role) {
        this.nameRole=role.nameRole();
        return this;
    }
}
