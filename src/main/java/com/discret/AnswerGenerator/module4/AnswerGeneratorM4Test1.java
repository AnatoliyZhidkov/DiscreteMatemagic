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
public class AnswerGeneratorM4Test1  {




    public String generateAnswer(List<QuestionSession> questionSessionList,QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return answerFirstQuestion(numbers);
            case 2: return answerSecondQuestion(numbers);
            case 3: return answerThirdQuestion(numbers);
            case 4: return answerFourthQuestion(numbers);
            case 5: return answerFifthQuestion(numbers);
            case 6: return answerSixthQuestion(numbers);
            case 7: return "нет";
            case 8: return "да";
            case 9: return "12";
            case 10: return "1";
            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }
    public String answerFirstQuestion( List<Integer> numbers){
        if (numbers.get(0) % 2 == 0){
            return String.valueOf((numbers.get(0)*numbers.get(0))/4);
        }
        return String.valueOf((numbers.get(0)+1*numbers.get(0)+1)/4);

    }

    public String answerSecondQuestion(List<Integer> numbers){
        return answerFirstQuestion(numbers);
    }

    public String answerThirdQuestion(List<Integer> numbers){
        return String.valueOf(numbers.get(1)*numbers.get(2)/numbers.get(0));
    }

    public String answerFourthQuestion(List<Integer> numbers){
        return String.valueOf(((2 + (numbers.get(0)-1)/2)*numbers.get(0))/numbers.get(1));
    }

    public String answerFifthQuestion(List<Integer> numbers){
       int x,y;
       x = schet(numbers.get(0), numbers.get(3));
       y = schet(numbers.get(3), numbers.get(0));
       return String.valueOf(x+y);
    }
    public int schet (int hG, int gH){
        if(hG<gH){
            hG *= 2;
            return schet(hG, gH);
        }
        return hG;
    }

    public String answerSixthQuestion(List<Integer> numbers){
        if (numbers.get(0) % 2 == 0){
            return "да";
        }
        return "нет";
    }

}
