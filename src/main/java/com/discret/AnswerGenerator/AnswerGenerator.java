package com.discret.AnswerGenerator;


import com.discret.AnswerGenerator.module1.AnswerGeneratorM1Test1;
import com.discret.AnswerGenerator.module1.AnswerGeneratorM1Test2;
import com.discret.AnswerGenerator.module1.AnswerGeneratorM1Test3;
import com.discret.AnswerGenerator.module2.AnswerGeneratorM2Test1;
import com.discret.AnswerGenerator.module2.AnswerGeneratorM2Test2;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM3Test1;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM3Test2;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM4Test1;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM4Test2;
import com.discret.entity.test.Question;
import com.discret.entity.test.QuestionSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;
@Service
@RequiredArgsConstructor
public class AnswerGenerator implements AnswerGeneratorInterface {

    public String generateAnswer(List<QuestionSession> questionSessionList,QuestionSession question, List<Integer> numbers){
        switch(question.getQuestion().getTest().getModule()){
            case 1:
                return generateAnswerModule1(questionSessionList,question,numbers);
            case 2:
                return generateAnswerModule2(question,numbers);
            case 3:
                return generateAnswerModule3(question,numbers);
            case 4:
                 return generateAnswerModule4(questionSessionList,question,numbers);
            default: throw new IllegalArgumentException("Unknown module: " + question.getQuestion().getTest().getModule());
        }
    }
    private final AnswerGeneratorM1Test1 answerGeneratorM1Test1;
    private final AnswerGeneratorM1Test2 answerGeneratorM1Test2;
    private final AnswerGeneratorM1Test3 answerGeneratorM1Test3;
    public String generateAnswerModule1(List<QuestionSession> questionSessionList,QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getTest().getNumber()){
            case 1:
                return answerGeneratorM1Test1.generateAnswer(questionSessionList,question,numbers);
            case 2:
                return answerGeneratorM1Test2.generateAnswer(question,numbers);
            case 3:
                return answerGeneratorM1Test3.generateAnswer(question,numbers);
            default: throw new IllegalArgumentException("Unknown  test: module-" + question.getQuestion().getTest().getModule() + " test-" +question.getQuestion().getTest().getNumber());
        }
    }
    private final AnswerGeneratorM2Test1 answerGeneratorM2Test1;
    private final AnswerGeneratorM2Test2 answerGeneratorM2Test2;
    public String generateAnswerModule2(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getTest().getNumber()){
            case 1:
                return answerGeneratorM2Test1.generateAnswer(question,numbers);
            case 2:
                return answerGeneratorM2Test2.generateAnswer(question,numbers);
            default: throw new IllegalArgumentException("Unknown  test: module-" + question.getQuestion().getTest().getModule() + " test-" +question.getQuestion().getTest().getNumber());
        }
    }
    private final AnswerGeneratorM3Test1 answerGeneratorM3Test1;
    private final AnswerGeneratorM3Test2 answerGeneratorM3Test2;

    public String generateAnswerModule3(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getTest().getNumber()){
            case 1:
                return answerGeneratorM3Test1.generateAnswer(question,numbers);
            case 2:
                return answerGeneratorM3Test2.generateAnswer(question,numbers);
            default: throw new IllegalArgumentException("Unknown  test: module-" + question.getQuestion().getTest().getModule() + " test-" +question.getQuestion().getTest().getNumber());
        }
    }
    private final AnswerGeneratorM4Test1 answerGeneratorM4Test1;
    private final AnswerGeneratorM4Test2 answerGeneratorM4Test2;
    public String generateAnswerModule4(List<QuestionSession> questionSessionList,QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getTest().getNumber()){
            case 1:
                return answerGeneratorM4Test1.generateAnswer(questionSessionList,question,numbers);
            case 2:
                return answerGeneratorM4Test2.generateAnswer(question,numbers);
            default: throw new IllegalArgumentException("Unknown  test: module-" + question.getQuestion().getTest().getModule() + " test-" +question.getQuestion().getTest().getNumber());
        }
    }



}
