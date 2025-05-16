package com.costSystemProject.api.service;

import com.costSystemProject.api.domain.costCenter.CostCenter;
import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.dto.CostCenterDto;
import com.costSystemProject.api.repository.CostCenterRepository;
import com.costSystemProject.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CostCenterService {
    @Autowired
    private CostCenterRepository costCenterRepository;

    public List<CostCenterDto> findAll(){
        List<CostCenter> costCenterList = costCenterRepository.findAll();
        return costCenterList
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ResponseEntity<CostCenterDto> findById(UUID id){
        return costCenterRepository.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    public CostCenterDto convertToDto(CostCenter costCenter){
        return new CostCenterDto(
                costCenter.getId(),
                costCenter.getName(),
                costCenter.getDescription()
        );
    }
}
