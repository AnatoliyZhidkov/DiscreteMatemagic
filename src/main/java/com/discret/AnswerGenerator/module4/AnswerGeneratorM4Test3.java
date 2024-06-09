package com.discret.AnswerGenerator.module4;

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
public class AnswerGeneratorM4Test3  {




    public String generateAnswer(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return "5";
            case 2: return "0";
            case 3: return "267";
            case 4: return "3";
            case 5: return "0";
            case 6: return "123";
            case 7: return "1,1,1";
            case 8: return "2,1,2";
            case 9: return "3,2,4";
            case 10: return "4,2,4";
            case 11: return "4,4,4";

            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }



}
