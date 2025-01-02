package com.example.PSM01.DTO.EmployeeDto.RoleDto;

import jakarta.validation.constraints.NotBlank;

public record DtoRole(
        @NotBlank
        String nameRole
) {
}
