package com.discret.entity.test;


import com.discret.entity.test.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

}
