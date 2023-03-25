package com.management.system.service;

import com.management.system.model.DTO.StudentRecordSaveRequest;
import com.management.system.model.DTO.StudentRecordUpdateRequest;
import com.management.system.model.StudentRecords;
import com.management.system.model.User;

import java.util.List;
import java.util.Optional;

public interface StudentRecordsService {
    List<StudentRecords> getAllRecordsForOneStudent(String email);
    StudentRecords getStudentRecordByID(int id);
    StudentRecords updateStudentRecord(int id, StudentRecordUpdateRequest marksUpdateDetails);
    String deleteRecord(int id);
    StudentRecords addRecord(StudentRecordSaveRequest newRecord,String userEmail);
    List<StudentRecords> addMultipleRecord(User user);


}
