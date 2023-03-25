package com.management.system.controller;

import com.management.system.model.DTO.*;
import com.management.system.model.StudentRecords;
import com.management.system.model.User;
import com.management.system.service.StudentRecordsService;
import com.management.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Slf4j
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentRecordsService studentRecordsService;

    @PostMapping("/signing")
    public SigningResponse signing(@RequestBody SigningRequest userCredentials) {
        User user = userService.login(userCredentials.getEmail(), userCredentials.getPassword());
        return new SigningResponse(user.getUserName(), user.getRole());
    }

    @GetMapping("/{email}")
    public User FetchUserByEmail(@PathVariable String email) {
        return userService.fetchUserByEmail(email);
    }

    @GetMapping("/all-students")
    public List<User> getAllStudents() {
        log.info("initiate the saving process");
        return userService.getAllStudent();
    }

    @PostMapping()
    public ResponseEntity<StudentSaveResponse> saveStudent(@RequestBody StudentSaveRequest student) {
        User addedNewStudent = userService.addStudent(student);
        List<StudentRecords> defaultRecords = studentRecordsService.addMultipleRecord(addedNewStudent);

        StudentSaveResponse studentSaveResponse = new StudentSaveResponse();
        studentSaveResponse.setRole(addedNewStudent.getRole());
        studentSaveResponse.setName(addedNewStudent.getName());
        studentSaveResponse.setUserName(addedNewStudent.getUserName());
        studentSaveResponse.setSex(addedNewStudent.getSex());
        studentSaveResponse.setDob(addedNewStudent.getDob());
        studentSaveResponse.setSchool(addedNewStudent.getSchool());
        studentSaveResponse.setProgram(addedNewStudent.getProgram());
        studentSaveResponse.setStudentRecordSaveRequest(defaultRecords);

        return new ResponseEntity<>(studentSaveResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        return new ResponseEntity<>(userService.deleteStudent(studentId), HttpStatus.CREATED);
    }

    @PutMapping("/{studentEmail}")
    public ResponseEntity<StudentUpdateResponse> UpdateStudent(@PathVariable String studentEmail, @RequestBody StudentUpdateRequest studentUpdateRequest) {
        StudentUpdateResponse studentUpdateResponse = new StudentUpdateResponse();
        User updateStudent = userService.updateStudent(studentEmail, studentUpdateRequest);
        BeanUtils.copyProperties(updateStudent, studentUpdateResponse);
        return new ResponseEntity<>(studentUpdateResponse, HttpStatus.CREATED);
    }
}
