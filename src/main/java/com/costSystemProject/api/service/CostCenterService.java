package com.costSystemProject.api.service;

import com.costSystemProject.api.domain.costCenter.CostCenter;
import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.repository.CostCenterRepository;
import com.costSystemProject.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostCenterService {
    @Autowired
    private CostCenterRepository costCenterRepository;

    public List<CostCenter> findAll(){
        return costCenterRepository.findAll();
    }
}
