package com.discret.AnswerGenerator.module1;

import com.discret.AnswerGenerator.AbstractAnswerGenerator;
import com.discret.AnswerGenerator.AnswerGenerator;
import com.discret.AnswerGenerator.module3.AnswerGeneratorM3Test1;
import com.discret.entity.test.Question;
import com.discret.entity.test.QuestionSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerGeneratorM1Test3 extends AbstractAnswerGenerator {


    public String generateAnswer(QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return "2598960";
            case 2: return answerSecondQuestion(numbers);
            case 3: return "214";
            case 4: return "221";
            case 5: return answerFifthQuestion(numbers);
            case 6: return answerSixthQuestion(numbers);
            case 7: return answerSeventhQuestion(numbers);
            case 8: return "350";
            case 9: return "1000";
            case 10: return "220";
            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }


    public String answerSecondQuestion(List<Integer> numbers){
        return String.valueOf(factorial(numbers.get(0))/(factorial(numbers.get(0)-numbers.get(1))*factorial(numbers.get(1))));
    }

    public String answerFifthQuestion(List<Integer> numbers){
        return String.valueOf(
                (355687428096000L/factorial(17-numbers.get(0))*factorial(numbers.get(0)))
                        *
                   (6227020800L/(factorial(13-numbers.get(1))*factorial(numbers.get(1)))));
    }

    public String answerSixthQuestion(List<Integer> numbers){
        return String.valueOf
                (
                      factorial(numbers.get(0)+numbers.get(1)-1 )
                         /
                        (factorial(numbers.get(0)-1) * factorial(numbers.get(1)) )
        );
    }

    public String answerSeventhQuestion(List<Integer> numbers){
        return String.valueOf(
                factorial(numbers.get(0))
                /
                        (factorial(numbers.get(0)-5) * 120)
        )
        ;
    }


}
