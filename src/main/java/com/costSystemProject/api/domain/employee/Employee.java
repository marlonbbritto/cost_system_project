package com.costSystemProject.api.domain.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "tb_employee")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Position position;
    @Enumerated(EnumType.STRING)
    private Level level;
    private String email;
    private LocalDate birthDate;
    private LocalDate dateOfHiring;
    @Enumerated(EnumType.STRING)
    private TypeOfContract typeOfContract;
    private Double salary;
    private Double valueOfBenefitsCard;
    private Double valueOfHealthPlans;
    private Double valueOfOtherBenefits;


}
