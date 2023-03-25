package com.management.system.service.impl;

import com.management.system.model.DTO.StudentRecordSaveRequest;
import com.management.system.model.DTO.StudentRecordUpdateRequest;
import com.management.system.model.StudentRecords;
import com.management.system.model.User;
import com.management.system.repository.StudentRecordsRepository;
import com.management.system.service.StudentRecordsService;
import com.management.system.service.UserService;
import com.management.system.utils.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public StudentRecords updateStudentRecord(int id, StudentRecordUpdateRequest marksUpdateDetails) {
        StudentRecords existingRecord = getStudentRecordByID(id);
        existingRecord.setMarks(marksUpdateDetails.getMarks());
        existingRecord.setModuleName(marksUpdateDetails.getModuleName());
        existingRecord.setModuleCode(marksUpdateDetails.getModuleCode());
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
    public StudentRecords addRecord(StudentRecordSaveRequest record, String userEmail) {
        StudentRecords newRecord = new StudentRecords();
        newRecord.setModuleCode(record.getModuleCode());
        newRecord.setModuleName(record.getModuleName());
        newRecord.setMarks(record.getMarks());
        newRecord.setUser(record.getUser());
        newRecord.setUser(userService.fetchUserByEmail(userEmail));
        return studentRecordsRepository.save(newRecord);
    }

    @Override
    public List<StudentRecords> addMultipleRecord(User user) {

        List<StudentRecords> saveMultipleRecords = Records.defaultRecordValues(user)
                .stream()
                .map(record -> new StudentRecords(null,
                        record.getModuleCode(),
                        record.getModuleName(),
                        record.getMarks(),
                        record.getUser()))
                .collect(Collectors.toList());

        return studentRecordsRepository.saveAll(saveMultipleRecords);

    }
}
