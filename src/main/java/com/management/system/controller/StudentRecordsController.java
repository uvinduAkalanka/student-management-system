package com.management.system.controller;

import com.management.system.model.DTO.StudentRecordSaveRequest;
import com.management.system.model.DTO.StudentSaveRequest;
import com.management.system.model.StudentRecords;
import com.management.system.model.User;
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

    @PutMapping("/{recordId}/{marks}")
    public StudentRecords updateStudentRecord(@PathVariable int recordId, @PathVariable String marks) {
        return studentRecordsService.updateStudentRecord(recordId, marks);
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
