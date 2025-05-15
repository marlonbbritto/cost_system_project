package com.costSystemProject.api.service;

import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.domain.employeeAllocation.EmployeeAllocation;
import com.costSystemProject.api.repository.EmployeeAllocationRepository;
import com.costSystemProject.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAllocationService {
    @Autowired
    private EmployeeAllocationRepository employeeAllocationRepository;

    public List<EmployeeAllocation> findAll(){
        return employeeAllocationRepository.findAll();
    }
}
