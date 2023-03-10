package com.management.system.service;

import com.management.system.model.Records;

import java.util.List;

public interface RecordsService {
    List<Records> getAllRecordsForStudent(String UserEmail);
    Records getAllRecords();
}
