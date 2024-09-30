package com.ishakteyran.pinsoft_assessment.controller;

import com.ishakteyran.pinsoft_assessment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
public class ProjectController {
    @Autowired
    private RPNCalculatorService rpnCalculatorService;
    @Autowired
    private MineSweeperService mineSweeperService;

    @PostMapping("/calculate")
    public Map<String, Double> calculate(@RequestBody Map<String, String> request) {
        String expression = request.get("expression");
        double result = rpnCalculatorService.calculateRPN(expression);
        return Map.of("result", result);
    }

    @PostMapping("/show-hints")
    public Map<String, String[]> showHints(@RequestBody Map<String, String[]> request) {
        String[] square = request.get("square");
        String[] hints = mineSweeperService.generateHints(square);
        return Map.of("hints", hints);
    }
}
