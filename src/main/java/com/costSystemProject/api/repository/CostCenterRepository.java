package com.costSystemProject.api.repository;

import com.costSystemProject.api.domain.costCenter.CostCenter;
import com.costSystemProject.api.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CostCenterRepository extends JpaRepository<CostCenter, UUID> {
}
