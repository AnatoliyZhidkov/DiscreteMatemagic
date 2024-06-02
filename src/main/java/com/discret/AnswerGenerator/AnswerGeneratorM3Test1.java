package com.discret.AnswerGenerator;

import com.discret.entity.test.Answer;

import java.util.Arrays;
import java.util.stream.Stream;

public class AnswerGeneratorM3Test1 extends AnswerGenerator{

    public Answer answerFirstQuestion(Answer a, int number){
        a.setAnswerText(String.valueOf(number*(number-1)/2));
        return a;
    }

    public int answerSecondQuestion(int number1, int number2){
        return number2*3+number1;
    }

    public int answerThirdQuestion(int number){
        return number*4/2;
    }

    public int answerFourthQuestion(int number){
        return number + 1;
    }

}
