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
public class AnswerGeneratorM4Test2  {




    public String generateAnswer(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return "да";
            case 2: return "adeghjibfklc";
            case 3: return "adebghjfcikl";
            case 4: return "2";
            case 5: return "18";
            case 6: return "124578";
            case 7: return "3480";
            case 8: return "40";
            case 9: return "0";

            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }



}
