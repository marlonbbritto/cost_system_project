package com.costSystemProject.api.service;

import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.dto.EmployeeDto;
import com.costSystemProject.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDto> findAll(){
        List<Employee> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ResponseEntity<EmployeeDto> findById(UUID id){
        return employeeRepository.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private EmployeeDto convertToDto(Employee employee){
        return new  EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getPosition(),
                employee.getLevel(),
                employee.getEmail(),
                employee.getBirthDate(),
                employee.getDateOfHiring(),
                employee.getTypeOfContract(),
                employee.getSalary(),
                employee.getValueOfBenefitsCard(),
                employee.getValueOfHealthPlans(),
                employee.getValueOfOtherBenefits()
        );
    }
}
