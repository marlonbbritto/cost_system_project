package com.costSystemProject.api.controller;

import com.costSystemProject.api.domain.costCenter.CostCenter;
import com.costSystemProject.api.domain.employee.Employee;
import com.costSystemProject.api.dto.CostCenterDto;
import com.costSystemProject.api.service.CostCenterService;
import com.costSystemProject.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cost_center")
public class CostCenterController {

    @Autowired
    private CostCenterService costCenterService;

    @GetMapping
    public ResponseEntity<List<CostCenterDto>> findAll(){
        List<CostCenterDto> costCenterList = costCenterService.findAll();
        return ResponseEntity.ok().body(costCenterList);
    }


}
