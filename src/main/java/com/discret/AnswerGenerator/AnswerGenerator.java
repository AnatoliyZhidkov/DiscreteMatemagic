package com.discret.AnswerGenerator;

import com.discret.AnswerGenerator.module1.AnswerGeneratorM1Test1;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM3Test1;
import com.discret.entity.test.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;
@Service
@RequiredArgsConstructor
public class AnswerGenerator implements AnswerGeneratorInterface {

    public String generateAnswer(Question question, List<Integer> numbers){
        switch(question.getTest().getModule()){
            case 1:
                return generateAnswerModule1(question,numbers);
            case 2:
                return generateAnswerModule2(question,numbers);
            case 3:
                return generateAnswerModule3(question,numbers);
            case 4:
                 return generateAnswerModule4(question,numbers);
            default: throw new IllegalArgumentException("Unknown module: " + question.getTest().getModule());
        }
    }
    private final AnswerGeneratorM1Test1 answerGeneratorM1Test1;
    public String generateAnswerModule1(Question question, List<Integer> numbers){
        switch (question.getTest().getNumber()){
            case 1:
                return answerGeneratorM1Test1.generateAnswer(question,numbers);
            case 2:
                return "";
            case 3:
                return "";
            default: throw new IllegalArgumentException("Unknown  test: module-" + question.getTest().getModule() + " test-" +question.getTest().getNumber());
        }
    }
    public String generateAnswerModule2(Question question, List<Integer> numbers){
        switch (question.getTest().getNumber()){
            case 1:
                return "";
            case 2:
                return "";
            default: throw new IllegalArgumentException("Unknown  test: module-" + question.getTest().getModule() + " test-" +question.getTest().getNumber());
        }
    }
    private final AnswerGeneratorM3Test1 answerGeneratorM3Test1;

    public String generateAnswerModule3(Question question, List<Integer> numbers){
        switch (question.getTest().getNumber()){
            case 1:
                return answerGeneratorM3Test1.generateAnswer(question,numbers);
            case 2:
                return "";
            default: throw new IllegalArgumentException("Unknown  test: module-" + question.getTest().getModule() + " test-" +question.getTest().getNumber());
        }
    }
    public String generateAnswerModule4(Question question, List<Integer> numbers){
        switch (question.getTest().getNumber()){
            case 1:
                return "";
            case 2:
                return "";
            default: throw new IllegalArgumentException("Unknown  test: module-" + question.getTest().getModule() + " test-" +question.getTest().getNumber());
        }
    }



}
