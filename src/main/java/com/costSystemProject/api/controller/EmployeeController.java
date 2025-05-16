package com.costSystemProject.api.controller;

import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.dto.EmployeeDto;
import com.costSystemProject.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll(){
        List<EmployeeDto> employeeDtoList = employeeService.findAll();
        return ResponseEntity.ok().body(employeeDtoList);
    }
}
