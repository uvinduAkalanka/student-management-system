package com.management.system.model.DTO;

import com.management.system.model.StudentRecords;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSaveResponse {
    private String role ;
    private String name;
    private String userName;
    private String sex;
    private String dob;
    private String school;
    private String program;
    private String yearOfStudy;
    private String currentStatus;
    private List<StudentRecords> studentRecordSaveRequest;

}
