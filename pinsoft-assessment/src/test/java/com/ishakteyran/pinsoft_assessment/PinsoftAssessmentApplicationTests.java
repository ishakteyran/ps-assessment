package com.ishakteyran.pinsoft_assessment;

import com.ishakteyran.pinsoft_assessment.service.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PinsoftAssessmentApplicationTests {

	private final RPNCalculatorService rpnCalculatorService = new RPNCalculatorService();
	private final MineSweeperService mineSweeperService = new MineSweeperService();

	@Test
	void testRPNCalculator() {
		assertEquals(6, rpnCalculatorService.calculateRPN("4 2 +"), 0.001);
		assertEquals(141, rpnCalculatorService.calculateRPN("3 5 8 * 7 + *"), 0.001);
		assertEquals(4, rpnCalculatorService.calculateRPN("20 5 /"), 0.001);
	}

	@Test
	void testMineSweeper() {
		String[] input = {"**...", ".....", ".*..."};
		String[] expected = {"**100", "33200", "1*100"};
		assertArrayEquals(expected, mineSweeperService.generateHints(input));

		String[] emptyInput = {".....", "....."};
		String[] emptyExpected = {"00000", "00000"};
		assertArrayEquals(emptyExpected, mineSweeperService.generateHints(emptyInput));

		String[] fullMineInput = {"***", "***", "***"};
		String[] fullMineExpected = {"***", "***", "***"};
		assertArrayEquals(fullMineExpected, mineSweeperService.generateHints(fullMineInput));
	}

}
