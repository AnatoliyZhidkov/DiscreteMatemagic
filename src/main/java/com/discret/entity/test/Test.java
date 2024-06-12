package com.discret.entity.test;


import com.discret.entity.Student_Groups;
import com.discret.entity.test.Question;
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

    private String name;
    private int number;
    private int module;
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> question;

    @Transient
    @ManyToMany(mappedBy = "test")
    private Set<Student_Groups> student_groups;

}
