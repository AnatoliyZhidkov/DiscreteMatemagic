package com.discret.AnswerGenerator;

import java.util.stream.Stream;

public abstract class AnswerGenerator implements AnswerGeneratorInterface {
    @Override
    public int[] getIntParams(String textParams) {
        return Stream.of(textParams.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
