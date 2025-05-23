package com.costSystemProject.api.controller;

import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.domain.employeeAllocation.EmployeeAllocation;
import com.costSystemProject.api.dto.EmployeeAllocationDto;
import com.costSystemProject.api.service.EmployeeAllocationService;
import com.costSystemProject.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/employees_allocation")
public class EmployeeAllocationController {

    @Autowired
    private EmployeeAllocationService employeeAllocationService;

    @GetMapping
    public ResponseEntity<List<EmployeeAllocationDto>> findAll(){
        List<EmployeeAllocationDto> employeeAllocationDtoList = employeeAllocationService.findAll();
        return ResponseEntity.ok().body(employeeAllocationDtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeAllocationDto> findById(@PathVariable UUID id){
        return employeeAllocationService.findById(id);
    }
}
