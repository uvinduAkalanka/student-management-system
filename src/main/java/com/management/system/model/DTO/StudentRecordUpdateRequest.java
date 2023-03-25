package com.management.system.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRecordUpdateRequest {
    private String moduleCode;
    private String moduleName;
    private String marks;
}
