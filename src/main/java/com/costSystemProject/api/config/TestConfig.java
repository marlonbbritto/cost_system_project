package com.costSystemProject.api.config;

import com.costSystemProject.api.domain.costCenter.CostCenter;
import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.domain.employee.Level;
import com.costSystemProject.api.domain.employee.Position;
import com.costSystemProject.api.domain.employee.TypeOfContract;
import com.costSystemProject.api.domain.employeeAllocation.EmployeeAllocation;
import com.costSystemProject.api.repository.CostCenterRepository;
import com.costSystemProject.api.repository.EmployeeAllocationRepository;
import com.costSystemProject.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeAllocationRepository employeeAllocationRepository;

    @Autowired
    private CostCenterRepository costCenterRepository;

    @Override
    public void run(String... args) throws Exception {


        CostCenter c1 = CostCenter.builder()
                .name("Projeto_Teste_A")
                .description("Projeto de transformação digital Fase A")
                .build();
        CostCenter c2 = CostCenter.builder()
                .name("Manutenção_Sistema_B")
                .description("Manutenção evolutiva do Sistema B")
                .build();
        CostCenter c3 = CostCenter.builder()
                .name("Inovação_Labs_X")
                .description("Laboratório de Inovação para novas tecnologias")
                .build();
        costCenterRepository.saveAll(List.of(c1, c2, c3));


        Employee e1 = Employee.builder()
                .name("João Silva")
                .position(Position.SOFTWARE_ENGINEER)
                .level(Level.PLENO)
                .email("joao.silva@gmail.com")
                .birthDate(LocalDate.of(1990, 5, 15))
                .dateOfHiring(LocalDate.now().minusYears(3))
                .typeOfContract(TypeOfContract.REMOTE)
                .salary(5500.50)
                .valueOfBenefitsCard(1200.00)
                .valueOfHealthPlans(600.00)
                .valueOfOtherBenefits(100.00)
                .build();
        Employee e2 = Employee.builder()
                .name("Maria Oliveira")
                .position(Position.BUSINESS_ANALYST)
                .level(Level.SÊNIOR)
                .email("maria.oliveira@gmail.com")
                .birthDate(LocalDate.of(1985, 10, 20))
                .dateOfHiring(LocalDate.now().minusYears(7))
                .typeOfContract(TypeOfContract.HYBRID)
                .salary(8200.75)
                .valueOfBenefitsCard(1500.00)
                .valueOfHealthPlans(750.00)
                .valueOfOtherBenefits(250.00)
                .build();
        Employee e3 = Employee.builder()
                .name("Pedro Souza")
                .position(Position.LEAD_SOFTWARE_ENGINEER)
                .level(Level.SÊNIOR)
                .email("pedro.souza@gmail.com")
                .birthDate(LocalDate.of(1988, 1, 25))
                .dateOfHiring(LocalDate.now().minusYears(5))
                .typeOfContract(TypeOfContract.ON_SITE)
                .salary(9800.90)
                .valueOfBenefitsCard(1800.00)
                .valueOfHealthPlans(800.00)
                .valueOfOtherBenefits(300.00)
                .build();
        employeeRepository.saveAll(List.of(e1, e2, e3));


        EmployeeAllocation ea1 = new EmployeeAllocation(null, e1, YearMonth.now(), 70.00, c1);
        EmployeeAllocation ea2 = new EmployeeAllocation(null, e1, YearMonth.now(), 30.00, c2);
        EmployeeAllocation ea3 = new EmployeeAllocation(null, e2, YearMonth.now(), 100.00, c1);
        EmployeeAllocation ea4 = new EmployeeAllocation(null, e3, YearMonth.now(), 50.00, c2);
        EmployeeAllocation ea5 = new EmployeeAllocation(null, e3, YearMonth.now(), 50.00, c3);
        employeeAllocationRepository.saveAll(List.of(ea1, ea2, ea3, ea4, ea5));


        e1.setAllocations(new ArrayList<>(List.of(ea1, ea2)));
        e2.setAllocations(new ArrayList<>(List.of(ea3)));
        e3.setAllocations(new ArrayList<>(List.of(ea4, ea5)));

        c1.setEmployeeAllocationList(new ArrayList<>(List.of(ea1, ea3)));
        c2.setEmployeeAllocationList(new ArrayList<>(List.of(ea2, ea4)));
        c3.setEmployeeAllocationList(new ArrayList<>(List.of(ea5)));

        employeeRepository.saveAll(List.of(e1, e2, e3));
        costCenterRepository.saveAll(List.of(c1, c2, c3));

        System.out.println("### Dados de teste criados com sucesso! ###");
    }
}