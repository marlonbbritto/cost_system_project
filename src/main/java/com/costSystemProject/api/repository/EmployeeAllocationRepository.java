package com.costSystemProject.api.repository;

import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.domain.employeeAllocation.EmployeeAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeAllocationRepository extends JpaRepository<EmployeeAllocation, UUID> {
}
