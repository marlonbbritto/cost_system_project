package com.costSystemProject.api.service;

import com.costSystemProject.api.domain.employeeAllocation.EmployeeAllocation;
import com.costSystemProject.api.dto.EmployeeAllocationDto;
import com.costSystemProject.api.repository.EmployeeAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeAllocationService {

    @Autowired
    private EmployeeAllocationRepository employeeAllocationRepository;

    public List<EmployeeAllocationDto> findAll(){
        List<EmployeeAllocation> employeeAllocations = employeeAllocationRepository.findAll();
        return employeeAllocations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ResponseEntity<EmployeeAllocationDto> findById(UUID id){
        return employeeAllocationRepository.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private EmployeeAllocationDto convertToDto(EmployeeAllocation allocation){
        return new EmployeeAllocationDto(
                allocation.getId(),
                allocation.getMonthAllocation(),
                allocation.getPercentage(),
                allocation.getEmployee().getId(),
                allocation.getEmployee().getName(),
                allocation.getCostCenter().getId(),
                allocation.getCostCenter().getName()
        );
    }
}