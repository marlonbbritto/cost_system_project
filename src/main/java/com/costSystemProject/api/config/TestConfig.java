package com.costSystemProject.api.config;

import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.domain.employee.Level;
import com.costSystemProject.api.domain.employee.Position;
import com.costSystemProject.api.domain.employee.TypeOfContract;
import com.costSystemProject.api.domain.employeeAllocation.EmployeeAllocation;
import com.costSystemProject.api.repository.EmployeeAllocationRepository;
import com.costSystemProject.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeAllocationRepository employeeAllocationRepository;

    @Override
    public void run(String... args) throws Exception {



        Employee e1 = Employee.builder()
                .name("João Silva")
                .position(Position.SOFTWARE_ENGINEER)
                .level(Level.PLENO)
                .email("joao.silva@gmail.com")
                .birthDate(LocalDate.now())
                .dateOfHiring(LocalDate.now())
                .typeOfContract(TypeOfContract.REMOTE)
                .salary(5000.11)
                .valueOfBenefitsCard(1000.00)
                .valueOfHealthPlans(500.00)
                .valueOfOtherBenefits(0.00)
                .build();

        EmployeeAllocation ea1 = new EmployeeAllocation(null,e1, YearMonth.now(),100.00);

        e1.setAllocations(List.of(ea1));

        employeeRepository.save(e1);
        employeeAllocationRepository.save(ea1);
    }
}
