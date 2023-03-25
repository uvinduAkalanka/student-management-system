package com.management.system.controller;

import com.management.system.model.DTO.StudentRecordSaveRequest;
import com.management.system.model.DTO.StudentRecordUpdateRequest;
import com.management.system.model.DTO.StudentRecordUpdateResponse;
import com.management.system.model.StudentRecords;
import com.management.system.service.StudentRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/student-records")
public class StudentRecordsController {

    @Autowired
    private StudentRecordsService studentRecordsService;

    @GetMapping("/{userEmail}")
    public List<StudentRecords> getAllRecordsForPerStudent(@PathVariable String userEmail) {
        return studentRecordsService.getAllRecordsForOneStudent(userEmail);
    }

    @GetMapping("/by-id/{recordID}")
    public StudentRecords getRecordByID(@PathVariable Integer recordID) {
        return studentRecordsService.getStudentRecordByID(recordID);
    }

    @PutMapping("/{recordId}")
    public ResponseEntity<StudentRecordUpdateResponse> updateStudentRecord(@PathVariable int recordId, @RequestBody StudentRecordUpdateRequest studentRecordUpdateRequest) {
        StudentRecords recordToUpdate = studentRecordsService.updateStudentRecord(recordId, studentRecordUpdateRequest);
        StudentRecordUpdateResponse studentRecordUpdateResponse = new StudentRecordUpdateResponse();
        studentRecordUpdateResponse.setModuleCode(recordToUpdate.getModuleCode());
        studentRecordUpdateResponse.setModuleName(recordToUpdate.getModuleName());
        studentRecordUpdateResponse.setMarks(recordToUpdate.getMarks());
        studentRecordUpdateResponse.setId(recordToUpdate.getId());
        return new ResponseEntity<>(studentRecordUpdateResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{recordId}")
    public String deleteStudent(@PathVariable int recordId) {
        return studentRecordsService.deleteRecord(recordId);
    }

    @PostMapping("/{userEmail}")
    public ResponseEntity<StudentRecords> saveRecord(@PathVariable String userEmail, @RequestBody StudentRecordSaveRequest record) {
        log.info("initiate the saving process");
        return new ResponseEntity<>(studentRecordsService.addRecord(record, userEmail), HttpStatus.CREATED);
    }
}
