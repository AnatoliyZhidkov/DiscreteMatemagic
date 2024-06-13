package com.discret.AnswerGenerator.module4;

import com.discret.AnswerGenerator.AnswerGenerator;
import com.discret.AnswerGenerator.module1.AnswerGeneratorM1Test1;
import com.discret.entity.test.Answer;
import com.discret.entity.test.Question;
import com.discret.entity.test.QuestionSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AnswerGeneratorM4Test1  {




    public String generateAnswer(List<QuestionSession> questionSessionList,QuestionSession question, List<Integer> numbers){
        switch (question.getQuestion().getQuestionNumber()){
            case 1: return answerFirstQuestion(numbers);
            case 2: return answerFirstQuestion(numbers);
            case 3: return answerThirdQuestion(numbers);
            case 4: return "11";
            case 5: return "18";
            case 6: return answerSixthQuestion(numbers);
            case 7: return "нет";
            case 8: return "да";
            case 9: return "12";
            case 10: return "1";
            default: throw new IllegalArgumentException("Unknown question" + question.getQuestion().getQuestionNumber());
        }
    }
    public String answerFirstQuestion( List<Integer> numbers){
        int totalPeople = numbers.get(0);
        int maxFlowers = 0;
        for (int boys = 1; boys < totalPeople; boys++) {
            int girls = totalPeople - boys;
            int flowers = boys * girls;
            if (flowers > maxFlowers) {
                maxFlowers = flowers;
            }
        }

        return String.valueOf(maxFlowers);
    }


    public String answerThirdQuestion(List<Integer> numbers){
        int numberOfBoys = (numbers.get(0) * 16) / 2;
        return String.valueOf(numberOfBoys);
    }


    public String answerSixthQuestion(List<Integer> numbers){
        if (numbers.get(0) % 2 == 0){
            return "да";
        }
        return "нет";
    }

}
