package com.management.system.model.DTO;

import com.management.system.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRecordSaveRequest {
    private String moduleCode;
    private String moduleName;
    private String marks;
    private User user;
}
