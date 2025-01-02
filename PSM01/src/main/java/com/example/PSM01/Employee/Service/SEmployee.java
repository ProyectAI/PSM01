package com.example.PSM01.Employee.Service;



import com.example.PSM01.DTO.EmployeeDto.DtoEmployee;
import com.example.PSM01.DTO.EmployeeDto.DtoRespuestaEmployee;
import com.example.PSM01.Employee.Model.Employee;
import com.example.PSM01.Employee.Repository.IEmployee;
import com.example.PSM01.Role.Model.Role;
import com.example.PSM01.Role.Repository.IRole;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SEmployee {

    @Autowired
    private IEmployee i;

    @Autowired
    private IRole iRole;

    //Method for saving employee data

    public List<Employee> listNameEmployeeAndRole() {
        return (List<Employee>) i.nameEmployeeAndNameRole();
    }


        @Transactional
        public Employee saveEmployee(DtoEmployee dtoEmployee) {
            // Intentar recuperar el Role existente por su nombre
            Role role = iRole.findByNameRole(dtoEmployee.role().nameRole())
                    .orElseThrow(() -> new IllegalArgumentException("Rol no existe"));

            // Crear y guardar la entidad Employee con el Role existente
            Employee employee = new Employee(dtoEmployee);
            employee.setRole(role); // Asociar el Role existente con Employee
            return i.save(employee);
        }


}
