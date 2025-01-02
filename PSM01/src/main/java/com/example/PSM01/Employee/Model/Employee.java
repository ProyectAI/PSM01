package com.example.PSM01.Employee.Model;


import com.example.PSM01.DTO.EmployeeDto.DtoEmployee;
import com.example.PSM01.DTO.EmployeeDto.DtoUpdateEmployee;
import com.example.PSM01.Role.Model.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_Employee")
    private String nameEmployee;
    private int phone;
    private String email;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;


    //Empty constructor


    public Employee() {
    }

    public Employee(DtoEmployee dtoEmployee) {
        this.nameEmployee= dtoEmployee.nameEmployee();
        this.phone= dtoEmployee.phone();
        this.email= dtoEmployee.email();
        this.role= new Role(dtoEmployee.role());

    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void updateDatos(DtoUpdateEmployee dtoUpdateEmployee) {
        if (dtoUpdateEmployee.nameEmployee() != null) {
            this.nameEmployee = dtoUpdateEmployee.nameEmployee();
        }
        if (dtoUpdateEmployee.phone() !=0 ){
            this.phone = dtoUpdateEmployee.phone();
        }
        if (dtoUpdateEmployee.email() != null) {
            this.email = dtoUpdateEmployee.email();
        }
        if (dtoUpdateEmployee.role() != null) {
            this.role = role.updateDatos(dtoUpdateEmployee.role());
        }

    }

}
