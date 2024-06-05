package com.discret.AnswerGenerator.module2;

import com.discret.AnswerGenerator.AnswerGenerator;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM3Test1;
import com.discret.entity.test.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerGeneratorM2Test2  {


    public String generateAnswer(Question question, List<Integer> numbers){
        switch (question.getQuestionNumber()){
            case 1: return answerFirstQuestion(numbers);
            case 2: return answerSecondQuestion(numbers);
            case 3: return answerThirdQuestion(numbers);
            case 4: return answerFourthQuestion(numbers);
            case 5: return "нет";
            case 6: return "23";
            case 7: return "13";
            case 8: return "24";
            case 9: return "24";
            case 10: return "24";
            case 11: return "24";
            case 12: return "24";
            case 13: return "24";
            default: throw new IllegalArgumentException("Unknown question" + question.getQuestionNumber());
        }
    }
    public String answerFirstQuestion( List<Integer> numbers){
        return String.valueOf(numbers.get(0)*(numbers.get(0)-1)/2);
    }

    public String answerSecondQuestion(List<Integer> numbers){
        return String.valueOf(numbers.get(1)*3+numbers.get(0));
    }

    public String answerThirdQuestion(List<Integer> numbers){
        return String.valueOf(numbers.get(0)*4/2);
    }

    public String answerFourthQuestion(List<Integer> numbers){
        return String.valueOf(numbers.get(0) + 1);
    }


}
