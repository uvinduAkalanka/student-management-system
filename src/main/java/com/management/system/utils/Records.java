package com.management.system.utils;

import com.management.system.model.DTO.StudentRecordSaveRequest;
import com.management.system.model.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Records {
    public static List<StudentRecordSaveRequest> defaultRecordValues(User user) {

        return Stream.of(
                new StudentRecordSaveRequest("COS-ENG",
                        "General English",
                        "",
                        user
                ),
                new StudentRecordSaveRequest("COS-PD",
                        "Professional Development",
                        "",
                        user
                ),
                new StudentRecordSaveRequest("COS-IQ",
                        "IQ Test",
                        "",
                        user
                ),
                new StudentRecordSaveRequest("COS-GT",
                        "General Knowledge",
                        "",
                        user
                )

        ).collect(Collectors.toList());

    }
}
