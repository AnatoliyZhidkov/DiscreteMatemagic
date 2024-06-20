package com.discret.entity.test;


import com.discret.entity.Student_Groups;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String testName;
    private int number;
    private int module;
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> question;

    @ManyToOne( )
    @JoinColumn(name = "partition_id")
    private Partition partition;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TestResult> testResults;


    @Transient
    @ManyToMany(mappedBy = "test")
    private Set<Student_Groups> student_groups;

}
