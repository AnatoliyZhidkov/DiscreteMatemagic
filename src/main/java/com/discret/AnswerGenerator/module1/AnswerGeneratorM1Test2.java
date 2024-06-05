package com.discret.AnswerGenerator.module1;

import com.discret.AnswerGenerator.AbstractAnswerGenerator;
import com.discret.AnswerGenerator.AnswerGenerator;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM3Test1;
import com.discret.entity.test.Question;
import com.discret.entity.test.QuestionSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerGeneratorM1Test2 extends AbstractAnswerGenerator {


    public String generateAnswer(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return "96";
            case 2: return answerSecondQuestion(numbers);
            case 3: return answerThirdQuestion(numbers);
            case 4: return "24";
            case 5: return "140";
            case 6: return "1680";
            case 7: return "6720";
            case 8: return "453600";
            case 9: return "360";
            case 10: return "228";

            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }


    public String answerSecondQuestion(List<Integer> numbers){
        return String.valueOf(numbers.get(0)*(numbers.get(0)-1)*(numbers.get(0)-2));
    }

    public String answerThirdQuestion(List<Integer> numbers){
        return String.valueOf(factorial(numbers.get(0)));
    }




}
