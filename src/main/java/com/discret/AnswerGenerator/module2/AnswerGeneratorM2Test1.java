package com.discret.AnswerGenerator.module2;

import com.discret.AnswerGenerator.AnswerGenerator;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM3Test1;
import com.discret.entity.test.Question;
import com.discret.entity.test.QuestionSession;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AnswerGeneratorM2Test1  {


    public String generateAnswer(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return "-12x^2yz";
            case 2: return "12xy";
            case 3: return "12x^4y";
            case 4: return "3";
            case 5: return "-30288";
            case 6: return "-19440";
            case 7: return "-84096";
            case 8: return "0";
            case 9: return "1680";
            case 10: return "630";
            case 11: return "180";
            case 12: return "560";


            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }

}
