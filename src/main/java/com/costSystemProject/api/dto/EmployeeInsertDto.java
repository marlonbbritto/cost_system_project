package com.costSystemProject.api.dto;

import com.costSystemProject.api.domain.employee.Level;
import com.costSystemProject.api.domain.employee.Position;
import com.costSystemProject.api.domain.employee.TypeOfContract;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record EmployeeInsertDto(
        @NotBlank(message = "O nome é obrigatório")
        String name,
        @NotNull(message = "A posição é obrigatória")
        Position position,
        @NotNull(message = "O nível é obrigatório")
        Level level,
        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,
        @NotNull(message = "A data de nascimento é obrigatória")
        @Past(message = "A data de nascimento deve ser no passado")
        LocalDate birthDate,
        @NotNull(message = "A data de contratação é obrigatória")
        LocalDate dateOfHiring,
        @NotNull(message = "O tipo de contrato é obrigatório")
        TypeOfContract typeOfContract,
        @NotNull(message = "O salário é obrigatório")
        Double salary,
        Double valueOfBenefitsCard,
        Double valueOfHealthPlans,
        Double valueOfOtherBenefits
) {
}
