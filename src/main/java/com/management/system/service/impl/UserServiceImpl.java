package com.management.system.service.impl;

import com.management.system.model.DTO.StudentSaveRequest;
import com.management.system.model.DTO.StudentUpdateRequest;
import com.management.system.model.User;
import com.management.system.repository.UserRepository;
import com.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User fetchUserByEmail(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(() -> new RuntimeException(String.format("user not found with the user name : %s", userName)));
    }

    @Override
    public User login(String userName, String password) {
        User user = fetchUserByEmail(userName);

        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new RuntimeException("Username or password is incorrect");
        }
    }

    @Override
    public List<User> getAllStudent() {
        userRepository.findByUserName("kamal@gmail.com");
        return userRepository
                .findAll()
                .stream()
                .filter(user -> Objects.equals(user.getRole(), "student"))
                .collect(Collectors.toList());

    }

    @Override
    public User addStudent(StudentSaveRequest student) {
        if (userRepository.findByUserName(student.getUserName()).isPresent()) {
            throw new RuntimeException("User with this username already exists!");
        }
        User newStudent = new User();
        newStudent.setRole(student.getRole());
        newStudent.setName(student.getName());
        newStudent.setUserName(student.getUserName());
        newStudent.setPassword(student.getPassword());
        newStudent.setSex(student.getSex());
        newStudent.setDob(student.getDob());
        newStudent.setSchool(student.getSchool());
        newStudent.setProgram(student.getProgram());
        userRepository.save(newStudent);
        return newStudent;
    }

    @Override
    public String deleteStudent(int id) {
        Optional<User> record = userRepository.findById(id);
        if (record.isPresent()) {
            userRepository.deleteById(id);
            return "successful";
        }
        return "Record not found";
    }

    @Override
    public User updateStudent(String studentEmail, StudentUpdateRequest updateStudent) {

        if (!Objects.equals(studentEmail, updateStudent.getUserName()) && (getAllStudent().stream().anyMatch(existingStudent ->
                existingStudent.getUserName().equals(updateStudent.getUserName())))) {
            throw new IllegalStateException("Student with email " + studentEmail + " already exists.");
        }

        User updateUserForDatabase = fetchUserByEmail(studentEmail);

        updateUserForDatabase.setRole(updateStudent.getRole());
        updateUserForDatabase.setName(updateStudent.getName());
        updateUserForDatabase.setUserName(updateStudent.getUserName());
        updateUserForDatabase.setSex(updateStudent.getSex());
        updateUserForDatabase.setDob(updateStudent.getDob());
        updateUserForDatabase.setSchool(updateStudent.getSchool());
        updateUserForDatabase.setProgram(updateStudent.getProgram());
        return userRepository.save(updateUserForDatabase);

    }
}
