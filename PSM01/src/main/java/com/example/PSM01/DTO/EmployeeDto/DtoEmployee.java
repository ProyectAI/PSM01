package com.example.PSM01.DTO.EmployeeDto;

import com.example.PSM01.DTO.EmployeeDto.RoleDto.DtoRole;
import com.example.PSM01.Role.Model.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoEmployee(

        @NotBlank
        String nameEmployee,
        @NotNull
        int phone,
        @NotBlank
        String email,
        @NotNull
        @Valid
        DtoRole role
) {
}
