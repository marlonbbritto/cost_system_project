package com.costSystemProject.api.dto;

import com.costSystemProject.api.domain.employee.Level;
import com.costSystemProject.api.domain.employee.Position;
import com.costSystemProject.api.domain.employee.TypeOfContract;
import java.time.LocalDate;
import java.util.UUID;

public record EmployeeDto(
        UUID id,
        String name,
        Position position,
        Level level,
        String email,
        LocalDate birthDate,
        LocalDate dateOfHiring,
        TypeOfContract typeOfContract,
        Double salary,
        Double valueOfBenefitsCard,
        Double valueOfHealthPlans,
        Double valueOfOtherBenefits

) {
}