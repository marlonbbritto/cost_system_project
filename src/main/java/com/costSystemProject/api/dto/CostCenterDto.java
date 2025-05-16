package com.costSystemProject.api.dto;

import java.util.UUID;

public record CostCenterDto(
        UUID id,
        String name,
        String description
) {
}
