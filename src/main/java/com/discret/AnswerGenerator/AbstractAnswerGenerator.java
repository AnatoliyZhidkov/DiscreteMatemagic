package com.discret.AnswerGenerator;

public abstract class AbstractAnswerGenerator {
    public Long factorial(Integer n) {
        if (n == 0) {
            return 1L;
        }
        return n * factorial(n - 1);
    }
}
