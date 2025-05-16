package com.costSystemProject.api.dto;


import lombok.Data;

import java.time.YearMonth;
import java.util.UUID;


public record EmployeeAllocationDto(
        UUID id,
        YearMonth monthAllocation,
        Double percentage,
        UUID employeeId,
        String employeeName,
        UUID costCenterId,
        String costCenterName) {
}
