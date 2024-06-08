package com.discret.repository.test;

import com.discret.entity.test.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult,Long> {


    List<TestResult> findAllByStudentId(Long studentId);
    @Query("SELECT t FROM TestResult t WHERE t.test.Id = ?1 AND t.student.id = ?2 ORDER BY t.startTime DESC LIMIT 1")
    TestResult findLastByTestIdAndStudentId(Long testId,Long studentId);

    boolean existsByTestIdAndStudentId(Long testId,Long studentId);
    boolean existsByIdAndStudentId(Long Id,Long studentId);

    int countByTestIdAndStudentId(Long testId,Long studentId);

    TestResult findByTestIdAndStudentId(Long testId, Long studentId);

    TestResult findLastByIdAndStudentId(Long testResultId,Long studentId);
}
