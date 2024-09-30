package com.ishakteyran.pinsoft_assessment.service;

import org.springframework.stereotype.Service;

import java.util.Stack;
import java.util.function.BiFunction;
import java.util.Map;

@Service
public class RPNCalculatorService {

    private final Map<String, BiFunction<Double, Double, Double>> operators = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
    );

    public double calculateRPN(String expression) {
        Stack<Double> stack = new Stack<>();

        for (String token : expression.split("\\s+")) {
            if (operators.containsKey(token)) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(operators.get(token).apply(a, b));
            } else {
                stack.push(Double.parseDouble(token));
            }
        }


        return stack.pop();
    }
}
