package com.management.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_records")
public class StudentRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_record_generator")
    @SequenceGenerator(name = "student_record_generator", sequenceName = "student_record_generator_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "module_code")
    private String moduleCode;
    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "marks")
    private String marks;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

//    public StudentRecords(String moduleCode, String moduleName, String marks, User user) {

//    }
}
