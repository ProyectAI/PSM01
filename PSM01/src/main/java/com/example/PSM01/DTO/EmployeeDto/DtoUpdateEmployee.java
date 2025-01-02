package com.example.PSM01.DTO.EmployeeDto;

import com.example.PSM01.DTO.EmployeeDto.RoleDto.DtoRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoUpdateEmployee(
        @NotNull
        Long id,

        String nameEmployee,

        int phone,

        String email,

        DtoRole role
                                ) {
}
