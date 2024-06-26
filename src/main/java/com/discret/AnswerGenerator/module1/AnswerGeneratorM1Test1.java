package com.discret.AnswerGenerator.module1;

import com.discret.AnswerGenerator.AbstractAnswerGenerator;
import com.discret.AnswerGenerator.AnswerGenerator;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM3Test1;
import com.discret.entity.test.Question;
import com.discret.entity.test.QuestionSession;
import com.discret.entity.test.TestResult;
import com.discret.repository.test.TestResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerGeneratorM1Test1 extends AbstractAnswerGenerator {

    private final TestResultRepository testResultRepository;
    public String generateAnswer(List<QuestionSession> questionSessionList,QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return answerFirstQuestion(numbers);
            case 2: return answerSecondQuestion(numbers);
            case 3: return answerThirdQuestion(numbers);
            case 4: return answerFourthQuestion(numbers);
            case 5: return answerFifthQuestion(numbers);
            case 6: return answerSixthQuestion(numbers);
            case 7: return answerSeventhQuestion(numbers);
            case 8: return answerEighthQuestion(numbers);
            case 9: return answerNinthQuestion(questionSessionList);
            case 10: return answerTenthQuestion(numbers);
            case 11: return "28561";
            case 12: return "17160";
            case 13: return answerThirteenthQuestion(numbers);


            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }
    public String answerFirstQuestion( List<Integer> numbers){
        return String.valueOf(Math.pow(3,numbers.get(0)));
    }

    public String answerSecondQuestion(List<Integer> numbers){
        return String.valueOf((int)(Math.pow(numbers.get(1),numbers.get(0))));
    }

    public String answerThirdQuestion(List<Integer> numbers){
        return String.valueOf((int)Math.pow(8,numbers.get(1))*Math.pow(10,numbers.get(0))-numbers.get(1));
    }

    public String answerFourthQuestion(List<Integer> numbers){
        return String.valueOf(numbers.get(0) * (numbers.get(0)-1));
    }
    public String answerFifthQuestion(List<Integer> numbers){
        return String.valueOf(9*(int)Math.pow(10,numbers.get(0)-1));
    }

    public String answerSixthQuestion(List<Integer> numbers){
        return String.valueOf(numbers.get(0) * (numbers.get(0)-1) * (numbers.get(0)-2));
    }

    public String answerSeventhQuestion(List<Integer> numbers){
        return String.valueOf((int)Math.pow(5,numbers.get(0)));
    }
    public String answerEighthQuestion(List<Integer> numbers){

        var num = numbers;

        return String.valueOf(factorial(numbers.get(1))/factorial(numbers.get(1)-numbers.get(0)));
    }

    public String answerNinthQuestion(List<QuestionSession> questionSessionList){
        List<Integer> numbers = Arrays.asList(questionSessionList.get(7).getGeneratedData().split(","))
                                      .stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return String.valueOf((int)Math.pow(numbers.get(1),numbers.get(0)));
    }

    public String answerTenthQuestion(List<Integer> numbers){
        return String.valueOf(9*(362880/factorial(10-numbers.get(0))));
    }

    public String answerThirteenthQuestion(List<Integer> numbers){
        // (one*(one-1)*(one-2)*two*(two-1)*(two-2)*three*(three-1)*(three-2)
        return String.valueOf(numbers.get(0)*(numbers.get(0)-1)*(numbers.get(0)-2)*numbers.get(1)*(numbers.get(1)-1)*(numbers.get(1)-2)*numbers.get(2)*(numbers.get(2)-1)*(numbers.get(2)-2));
    }
}
