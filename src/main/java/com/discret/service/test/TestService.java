package com.discret.service.test;

import com.discret.entity.test.Test;
import com.discret.repository.StudentsRepository;
import com.discret.repository.test.TestRepository;
import com.discret.repository.test.TestResultRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TestService implements TestServiceInt {

    private final TestResultRepository testResultRepository;
    private final TestRepository testRepository;
    private final PatitionService patitionService;

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

    public List<Test> findAllCustomTest(){

        return testRepository.findAllCustumTest();
    }


    public boolean addTest(String name, int number, Long partitionId) {

        Test test = new Test();
        test.setTestName(name);
        test.setNumber(number);
        test.setPartition(patitionService.findById(partitionId));
        testRepository.save(test);
        return true;
    }


    public List<Test> findAllTestsByPartitionId(Long partitonId) {
        return testRepository.findAllByPartitionId(partitonId);
    }

    public boolean deleteTest(Long testId) {

        this.testRepository.findById(testId)
                .orElseThrow(() -> new NoSuchElementException("Test not found"));
        this.testRepository.deleteById(testId);
        return true;

    }
}
