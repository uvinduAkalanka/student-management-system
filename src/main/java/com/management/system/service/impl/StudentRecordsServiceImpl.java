package com.management.system.service.impl;

import com.management.system.model.DTO.StudentRecordSaveRequest;
import com.management.system.model.StudentRecords;
import com.management.system.model.User;
import com.management.system.repository.StudentRecordsRepository;
import com.management.system.service.StudentRecordsService;
import com.management.system.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class StudentRecordsServiceImpl implements StudentRecordsService {
    @Autowired
    private StudentRecordsRepository studentRecordsRepository;
    @Autowired
    private UserService userService;

    public List<StudentRecords> getAllRecordsForOneStudent(String email) {
        User user = userService.fetchUserByEmail(email);
        return studentRecordsRepository.findByUser(user);
    }

    @Override
    public StudentRecords getStudentRecordByID(int id) {
        return studentRecordsRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Username or password is incorrect")
                );
    }

    @Override
    public StudentRecords updateStudentRecord(int id,String marks) {
        StudentRecords existingRecord = getStudentRecordByID(id);
        existingRecord.setMarks(marks);
        return studentRecordsRepository.save(existingRecord);

    }

    @Override
    public String deleteRecord(int id) {
        Optional<StudentRecords> record = studentRecordsRepository.findById(id);
        if (record.isPresent()) {
            studentRecordsRepository.deleteById(id);
            return "successful";
        }
        return "Record not found";
    }

    @Override
    public StudentRecords addRecord(StudentRecordSaveRequest record,String userEmail) {
        StudentRecords newRecord = new StudentRecords();
        newRecord.setModuleCode(record.getModuleCode());
        newRecord.setModuleName(record.getModuleName());
        newRecord.setMarks(record.getMarks());
        newRecord.setUser(record.getUser());
        newRecord.setUser(userService.fetchUserByEmail(userEmail));
        return studentRecordsRepository.save(newRecord);
    }
}
