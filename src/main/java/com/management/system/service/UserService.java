package com.management.system.service;

import com.management.system.model.DTO.StudentSaveRequest;
import com.management.system.model.DTO.StudentSaveResponse;
import com.management.system.model.DTO.StudentUpdateRequest;
import com.management.system.model.User;

import java.util.List;

public interface UserService {
    User login(String userName, String password);

    User fetchUserByEmail(String userName);

    List<User> getAllStudent();

    User addStudent(StudentSaveRequest student);

    String deleteStudent(int id);
    User updateStudent(String email, StudentUpdateRequest updateRequest);

}
