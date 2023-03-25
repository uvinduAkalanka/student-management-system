package com.management.system.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateResponse {
    private String name;
    private String userName;
    private String sex;
    private String dob;
    private String school;
    private String program;
    private String yearOfStudy;
    private String currentStatus;
}
