package com.discret.repository;

import com.discret.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
    Student findByLogin(String login);




    List<Student> findAll();

    boolean existsByLogin(String login);
}
