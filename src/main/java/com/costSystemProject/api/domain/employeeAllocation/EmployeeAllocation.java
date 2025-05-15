package com.costSystemProject.api.domain.employeeAllocation;

import com.costSystemProject.api.domain.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;
import java.time.YearMonth;
import java.util.UUID;

@Table(name = "tb_employee_allocation")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeAllocation {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
    private YearMonth monthAllocation;
    private Double percentage;
}
