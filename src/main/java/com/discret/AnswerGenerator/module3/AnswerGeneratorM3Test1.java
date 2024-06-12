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
public class AnswerGeneratorM3Test1  {




    public String generateAnswer(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return answerFirstQuestion(numbers);
            case 2: return answerSecondQuestion(numbers);
            case 3: return answerThirdQuestion(numbers);
            case 4: return answerFourthQuestion(numbers);
            case 5: return "нет";
            case 6: return "123";
            case 7: return "23";
            case 8: return "24";
            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
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
