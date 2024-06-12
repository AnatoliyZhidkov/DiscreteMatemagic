package com.discret.entity;

import com.discret.entity.test.Test;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity(name = "student_group")
public class Student_Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(name = "group_name")
    private String groupname;

   @Column(name = "group_number")
    private int groupNumber;

    @OneToMany(mappedBy = "student_groups", cascade = CascadeType.ALL)
    private List<Student> students;

    @ManyToMany
    @JoinTable(
            name = "student_group_test",
            joinColumns = @JoinColumn(name = "student_group_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id")
    )
    private Set<Test> test;


    public Student_Groups() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }
}
