package com.discret.AnswerGenerator.module3;

import com.discret.AnswerGenerator.AnswerGenerator;
import com.discret.AnswerGenerator.module1.AnswerGeneratorM1Test1;
import com.discret.entity.test.Answer;
import com.discret.entity.test.Question;
import com.discret.entity.test.QuestionSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class AnswerGeneratorM3Test2  {


    public String generateAnswer(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return answerFirstQuestion(numbers);
            case 2: return answerSecondQuestion(numbers);
            case 3: return answerThirdQuestion(numbers);
            case 4: return "1";
            case 5: return "2";
            case 6: return "1";
            case 7: return "34";
            case 8: return "1";
            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }
    public String answerFirstQuestion(List<Integer> numbers) {
        int firstNumber = numbers.get(0) - 1;
        int squared = firstNumber * firstNumber;
        return String.valueOf(squared);
    }

    public String answerSecondQuestion(List<Integer> numbers) {
        int firstNumber = numbers.get(0);
        int squared = firstNumber * firstNumber;
        int roundedDivision = Math.round(squared / 4.0f); // деление и округление до целого числа
        return String.valueOf(roundedDivision);
    }

    public String answerThirdQuestion(List<Integer> numbers){
        int n = numbers.get(0);
        double result = Math.pow(n, n - 2);
        return String.valueOf((long)result);
    }
}
