package com.management.system.controller;

import com.management.system.model.DTO.SigningRequest;
import com.management.system.model.DTO.SigningResponse;
import com.management.system.model.DTO.StudentSaveRequest;
import com.management.system.model.User;
import com.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

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
        return userService.getAllStudent();
    }

    @PostMapping()
    public ResponseEntity<User> saveStudent(@RequestBody StudentSaveRequest student) {
        return new ResponseEntity<>(userService.addStudent(student), HttpStatus.CREATED);
    }
     @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        return new ResponseEntity<>(userService.deleteStudent(studentId), HttpStatus.CREATED);
    }
}
