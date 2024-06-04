package com.discret.AnswerGenerator.module3;

import com.discret.AnswerGenerator.AnswerGenerator;
import com.discret.AnswerGenerator.module1.AnswerGeneratorM1Test1;
import com.discret.entity.test.Answer;
import com.discret.entity.test.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class AnswerGeneratorM3Test2  {




    public String generateAnswer(Question question, List<Integer> numbers){
        switch (question.getQuestionNumber()){
            case 1: return answerFirstQuestion(numbers);
            case 2: return answerSecondQuestion(numbers);
            case 3: return answerThirdQuestion(numbers);
            case 4: return "1";
            case 5: return "2";
            case 6: return "1";
            case 7: return "34";
            case 8: return "1";
            default: throw new IllegalArgumentException("Unknown question" + question.getQuestionNumber());
        }
    }
    public String answerFirstQuestion( List<Integer> numbers){
        return String.valueOf(numbers.get(0)*numbers.get(0));
    }

    public String answerSecondQuestion(List<Integer> numbers){
        return String.valueOf((numbers.get(0)*2)*numbers.get(0));
    }

    public String answerThirdQuestion(List<Integer> numbers){
        return String.valueOf((numbers.get(0)*2)*numbers.get(0));
    }




}
