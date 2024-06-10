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
            case 1: return answerFirstQuestion(numbers);
            case 2: return answerSecondQuestion(numbers);
            case 3: return answerThirdQuestion(numbers);
            case 4: return "132";
            case 5: return answerFifthQuestion(numbers);
            case 6: return answerSixthQuestion(numbers);
            case 7: return "tn?h!jojefao.jfaznh";
            case 8: return "recursion";
            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }

    public String answerFirstQuestion(List<Integer> numbers){
        return String.valueOf(recursion1(numbers.get(0)));
    }

    public Long recursion1(int n){
        if (n == 6) {
            return 22L;
        }
        return (long)Math.pow(2,n-1) - recursion1(n - 1);
    }

    public String answerSecondQuestion(List<Integer> numbers){
        return String.valueOf(recursion2(numbers.get(0)));
    }
    public Long recursion2(int n){
        if (n == 4) {
            return 60L;
        }
        if (n == 5){
            return 164L;
        }

        return 2*recursion2(n - 1) + 2*recursion2(n - 2);
    }


    public String answerThirdQuestion(List<Integer> numbers){
        return String.valueOf(recursion3(numbers.get(0)));
    }
    public int recursion3(int n){
        if (n == 4) {
            return 5;
        }
        if (n == 3){
            return 3;
        }

        return recursion3(n-2) + recursion3(n-1);
    }

    public String answerFifthQuestion(List<Integer> numbers){
        return String.valueOf(recursion5(numbers.get(0)));
    }
    public int recursion5(int n){
        if (n == 6) {
            return 21;
        }
        if (n == 5){
            return 13;
        }
        return recursion5(n-1) + recursion5(n-2);
    }


    public String answerSixthQuestion(List<Integer> numbers){
        return String.valueOf(recursion6(numbers.get(0)));
    }
    public int recursion6(int n){
        if (n == 6) {
            return 2;
        }
        if (n == 5){
            return 1;
        }
        if (n == 4){
            return 1;
        }
        return recursion6(n-3) + recursion6(n-2);
    }

}
