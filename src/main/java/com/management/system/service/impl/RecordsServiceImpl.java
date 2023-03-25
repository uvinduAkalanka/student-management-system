//package com.management.system.service.impl;
//
//import com.management.system.model.Records;
//import com.management.system.repository.RecordsRepository;
//import com.management.system.service.RecordsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@Service
//public class RecordsServiceImpl implements RecordsService {
//    private final RecordsRepository recordsRepository;
//
//    public RecordsServiceImpl(RecordsRepository recordsRepository) {
//        this.recordsRepository = recordsRepository;
//    }
//
//    @Override
//    public List<Records> getAllRecordsForStudent(String userEmail) {
//        return recordsRepository.findAll();
////                .findAll()
////                .stream()
////                .filter(record -> Objects.equals(record.getUser().getUserName(), userEmail))
////                .collect(Collectors.toList())
////                ;
//    }
//
//    @Override
//    public Records getAllRecords() {
//        return null;
//    }
//}
