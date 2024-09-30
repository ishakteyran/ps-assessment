package com.ishakteyran.pinsoft_assessment.service;

import org.springframework.stereotype.Service;

@Service
public class MineSweeperService {

    public String[] generateHints(String[] square) {
        int rows = square.length;
        int cols = square[0].length();
        char[][] result = new char[rows][cols];

        // Initialize teh result with 0 values.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = '0';
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (square[i].charAt(j) == '*') {
                    result[i][j] = '*'; // Mark the mine
                    determineSurroundingMines(result, i, j, rows, cols);
                }
            }
        }

        String[] hints = new String[rows];
        for (int i = 0; i < rows; i++) {
            hints[i] = new String(result[i]);
        }

        return hints;
    }

    private void determineSurroundingMines(char[][] result, int row, int col, int rows, int cols) {
        for (int i = Math.max(0, row - 1); i <= Math.min(rows - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(cols - 1, col + 1); j++) {
                if (result[i][j] != '*') {
                    char currentChar = result[i][j];
                    if (currentChar < '8') {
                        // Convert char to int, increment, then back to char
                        int currentValue = Character.getNumericValue(currentChar);
                        char newChar = Character.forDigit(currentValue + 1, 10);
                        result[i][j] = newChar;
                    }
                }
            }
        }
    }
}
