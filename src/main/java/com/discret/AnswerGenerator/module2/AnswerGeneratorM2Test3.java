package com.discret.AnswerGenerator.module2;

import com.discret.AnswerGenerator.AbstractAnswerGenerator;
import com.discret.AnswerGenerator.AnswerGenerator;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM3Test1;
import com.discret.entity.test.Question;
import com.discret.entity.test.QuestionSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerGeneratorM2Test3 extends AbstractAnswerGenerator {


    public String generateAnswer(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return "945x^4";
            case 2: return "-20x^(3/2)y^(3/2)";
            case 3: return answerThirdQuestion(numbers);
            case 4: return "35";
            case 5: return "924a^(-3";
            case 6: return "10";
            case 7: return "5";
            case 8: return "84";
            case 9: return "924";
            case 10: return answerTenthQuestion(numbers);

            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }



    public String answerThirdQuestion(List<Integer> numbers){
        return String.valueOf( factorial(numbers.get(1)) / (factorial(numbers.get(0)) * factorial(numbers.get(1)-numbers.get(0))));
    }

    public String answerTenthQuestion(List<Integer> numbers){
        return String.valueOf(numbers.get(0) + numbers.get(1));
    }


}
