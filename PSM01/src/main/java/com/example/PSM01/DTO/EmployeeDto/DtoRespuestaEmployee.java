package com.example.PSM01.DTO.EmployeeDto;

import com.example.PSM01.DTO.EmployeeDto.RoleDto.DtoRole;
import com.example.PSM01.Role.Model.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoRespuestaEmployee(

        Long id,

        String nameEmployee,

        int phone,

        String email,

        DtoRole role
) {
}
