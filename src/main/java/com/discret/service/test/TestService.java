package com.discret.service.test;

import com.discret.entity.test.Test;
import com.discret.repository.StudentsRepository;
import com.discret.repository.test.TestRepository;
import com.discret.repository.test.TestResultRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService implements TestServiceInt {

    private TestResultRepository testResultRepository;
    private TestRepository testRepository;
    private StudentsRepository studentsRepository;

    public Test findById(Long testid){
        return testRepository.findById(testid).orElseThrow(() -> new EntityNotFoundException("Test not found"));
    }
}
