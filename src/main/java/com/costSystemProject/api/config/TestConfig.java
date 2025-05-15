package com.costSystemProject.api.config;

import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.domain.employee.Level;
import com.costSystemProject.api.domain.employee.Position;
import com.costSystemProject.api.domain.employee.TypeOfContract;
import com.costSystemProject.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        Employee e1 = new Employee(null,"João Silva", Position.SOFTWARE_ENGINEER, Level.PLENO,"joao.silva@gmail.com", LocalDate.now(),LocalDate.now(), TypeOfContract.REMOTE,5000.11,1000.00,500.00,0.00);

        employeeRepository.save(e1);
    }
}
