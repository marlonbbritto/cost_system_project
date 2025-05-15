package com.costSystemProject.api.domain.employee;

import com.costSystemProject.api.domain.employeeAllocation.EmployeeAllocation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Table(name = "tb_employee")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
    @OneToMany
    @Builder.Default
    private List<EmployeeAllocation> allocations = List.of();


}
