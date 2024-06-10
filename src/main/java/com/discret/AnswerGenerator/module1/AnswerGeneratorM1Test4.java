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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerGeneratorM1Test4 extends AbstractAnswerGenerator {

    public String generateAnswer(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return answerFirstQuestion(numbers);
            case 2: return answerSecondQuestion(numbers);
            case 3: return answerThirdQuestion(numbers);
            case 4: return "SDCTEIRE";
            case 5: return answerFifthQuestion(numbers);
            case 6: return answerSixthQuestion(numbers);
            case 7: return answerSeventhQuestion(numbers);
            case 8: return answerEighthQuestion(numbers);
            case 9: return answerNinthQuestion(numbers);
            case 10: return "343975126667256";
            case 11: return "4514457600000";
            case 12: return answerTwelthQuestion(numbers);
            case 13: return "2000000";


            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }
    public String answerFirstQuestion( List<Integer> numbers){
        return String.valueOf(factorial(5)/factorial(5-numbers.get(0)));
    }

    public String answerSecondQuestion(List<Integer> numbers){
        return String.valueOf((long)(Math.pow(10,numbers.get(0))));
    }

    public String answerThirdQuestion(List<Integer> numbers){
        return String.valueOf(factorial(numbers.get(0)));
    }


    public String answerFifthQuestion(List<Integer> numbers){
        return String.valueOf(factorial(7)/(factorial(numbers.get(0))*factorial(7-numbers.get(0))));
    }

    public String answerSixthQuestion(List<Integer> numbers){
        return String.valueOf(factorial(11)/factorial(11-numbers.get(0)));
    }

    public String answerSeventhQuestion(List<Integer> numbers){
        return String.valueOf((long)Math.pow(33,numbers.get(0)));
    }
    public String answerEighthQuestion(List<Integer> numbers){
        return String.valueOf((long)Math.pow(62,numbers.get(0)));
    }

    public String answerNinthQuestion(List<Integer> numbers){

        BigInteger base = BigInteger.valueOf(62);
        int exponent = numbers.get(0);
        BigInteger powerResult = base.pow(exponent);

        // Преобразование BigInteger в BigDecimal для точного умножения на 0.1
        BigDecimal powerResultDecimal = new BigDecimal(powerResult);
        BigDecimal multiplier = new BigDecimal("0.1");
        BigDecimal finalResult = powerResultDecimal.multiply(multiplier);
        return String.valueOf(finalResult);
    }




    public String answerTwelthQuestion(List<Integer> numbers){
        return String.valueOf(
                factorial(numbers.get(0))
                        /
                        (factorial(numbers.get(1))*(factorial(numbers.get(0)-numbers.get(1))))
                );
    }

}
