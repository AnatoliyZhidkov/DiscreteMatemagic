package com.discret.service.test;

import com.discret.entity.test.Test;
import com.discret.repository.StudentsRepository;
import com.discret.repository.test.TestRepository;
import com.discret.repository.test.TestResultRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TestService implements TestServiceInt {

    private final TestResultRepository testResultRepository;
    private final TestRepository testRepository;

    private final StudentsRepository studentsRepository;

    public Test findById(Long testid){

        return testRepository.findById(testid)
                .orElseThrow(() -> new EntityNotFoundException("Test not found"));

    }
    @Transactional
    public Test findTestByModuleAndNumber(int Module,int Number){
        return testRepository.findByModuleAndAndNumber( Module, Number)
                .orElseThrow(() -> new EntityNotFoundException("Test not found"));
    }

    public boolean createTest(String name, int section, int testNumber){
        this.testRepository.findByModuleAndAndNumber(section, testNumber)
                .ifPresentOrElse
                        (test -> {
                                test.setName(name);
                                test.setNumber(testNumber);
                                test.setModule(section);
        },() -> {throw new NoSuchElementException();});

        return true;
    }


}
