package com.example.PSM01.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
}
