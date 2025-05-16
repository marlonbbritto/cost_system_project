package com.costSystemProject.api.domain.costCenter;

import com.costSystemProject.api.domain.employeeAllocation.EmployeeAllocation;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "tb_cost_center")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CostCenter {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "costCenter")
    @Builder.Default
    private List<EmployeeAllocation> employeeAllocationList = new ArrayList<>();
}
