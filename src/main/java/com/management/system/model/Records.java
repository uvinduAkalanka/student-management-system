package com.management.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RecordsId.class)
@Entity
public class Records {
    @Id
    @Column(name = "module_code")
    private String moduleCode;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "marks")
    private String marks;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
