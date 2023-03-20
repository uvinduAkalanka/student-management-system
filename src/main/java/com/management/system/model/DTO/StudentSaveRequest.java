package com.management.system.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSaveRequest {
    private String role = "student";
    private String name;
    private String userName;
    private String password = "12345";
    private String sex;
    private String dob;
    private String school;
    private String program;
    private String yearOfStudy;
    private String currentStatus;
}
