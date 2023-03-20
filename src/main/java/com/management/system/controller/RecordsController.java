package com.management.system.controller;

import com.management.system.model.Records;
import com.management.system.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/record")
public class RecordsController {

    @Autowired
    private RecordsService recordsService;

    @GetMapping("/{studentEmail}")
    public List<Records> getAllRecordsForStudent(@PathVariable String studentEmail) {
        return recordsService.getAllRecordsForStudent(studentEmail);
    }
}
