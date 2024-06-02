package com.discret.AnswerGenerator;

import java.util.Arrays;
import java.util.stream.Stream;

public class AnswerGeneratorM3Test1 extends AnswerGenerator{

    public int answerFirstQuestion(int number){
        return number*(number-1)/2;
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
