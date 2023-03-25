package com.management.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_id_seq", allocationSize = 1)
    private Integer id;
    @NonNull
    @Column(name = "role")
    private String role ;
    @Column(name = "student_name")
    private String name;
    @Column(name = "user_name")
    private String userName;
    @NonNull
    @Column(name = "password")
    private String password;
    @Column(name = "Sex")
    private String sex;
    @Column(name = "date_of_birth")
    private String dob;
    @Column(name = "school")
    private String school;
    @Column(name = "enrolled_program")
    private String program;
    @Column(name = "year_of_study")
    private String yearOfStudy;
    @Column(name = "current_status")
    private String currentStatus;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<StudentRecords> records;
}



