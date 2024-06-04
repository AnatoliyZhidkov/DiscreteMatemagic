package com.discret.repository.test;

import com.discret.entity.test.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult,Long> {


    List<TestResult> findAllByStudentId(Long studentId);
}
