package com.management.system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;


import javax.persistence.*;
import java.util.List;

@Data
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
    private String role;
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
    @OneToMany(targetEntity = Records.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "UserRecord_FK",referencedColumnName = "moduleCode",updatable = false )
    @JsonBackReference
    private List<Records> records;
}



