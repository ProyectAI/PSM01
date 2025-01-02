package com.example.PSM01.Employee.Controller;

import com.example.PSM01.DTO.EmployeeDto.DtoEmployee;
import com.example.PSM01.DTO.EmployeeDto.DtoRespuestaEmployee;
import com.example.PSM01.DTO.EmployeeDto.DtoUpdateEmployee;
import com.example.PSM01.DTO.EmployeeDto.RoleDto.DtoRole;
import com.example.PSM01.Employee.Model.Employee;
import com.example.PSM01.Employee.Repository.IEmployee;
import com.example.PSM01.Employee.Service.SEmployee;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class CEmployee {

    @Autowired
    private SEmployee s;

    @Autowired
    private IEmployee i;

    @PostMapping
    @Transactional
    public ResponseEntity<DtoRespuestaEmployee> saveEmployee(@RequestBody @Valid DtoEmployee dtoEmployee, UriComponentsBuilder ub){
        Employee e =s.saveEmployee(dtoEmployee);
        DtoRespuestaEmployee dtoRespuestaEmployee = new DtoRespuestaEmployee(e.getId(), e.getNameEmployee(), e.getPhone(), e.getEmail(),
                new DtoRole(e.getRole().getNameRole()));
        URI url = ub.path("/employee/{id}").buildAndExpand(e.getId()).toUri();
        return ResponseEntity.created(url).body(dtoRespuestaEmployee);
    }


    @PutMapping
    @Transactional
    public ResponseEntity updateEmployee(@RequestBody @Valid DtoUpdateEmployee dtoUpdateEmployee){
        Employee e = i.getReferenceById(dtoUpdateEmployee.id());
        e.updateDatos(dtoUpdateEmployee);
        return ResponseEntity.ok(new DtoRespuestaEmployee(e.getId(), e.getNameEmployee(), e.getPhone(), e.getEmail(),
                new DtoRole(e.getRole().getNameRole())));
    }

    @GetMapping
    public void holamundo(){
        System.out.println("si funciona");
    }

    @GetMapping("/listrol")
    public List<Employee> listRolAndEmployee(){
        return s.listNameEmployeeAndRole();
    }

}
