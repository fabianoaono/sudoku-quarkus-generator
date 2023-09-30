package com.fabianoaono.sudoku.service;

import com.fabianoaono.sudoku.config.Difficulty;
import com.fabianoaono.sudoku.model.SudokuBoard;
import com.fabianoaono.sudoku.service.generator.SudokuGenerator;
import com.fabianoaono.sudoku.service.generator.SudokuGeneratorResult;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Random;

@ApplicationScoped
public class SudokuService {

    private final static int[][] values = {
        {0, 8, 9, 0, 0, 5, 1, 4, 0},
        {3, 0, 0, 8, 1, 7, 0, 0, 6},
        {7, 1, 0, 6, 0, 4, 3, 8, 0},
        {0, 4, 3, 9, 0, 0, 0, 0, 0},
        {9, 7, 0, 0, 0, 0, 0, 1, 4},
        {0, 0, 0, 0, 0, 8, 7, 3, 0},
        {0, 9, 6, 4, 0, 2, 0, 7, 1},
        {4, 0, 0, 1, 5, 9, 0, 0, 2},
        {0, 2, 1, 7, 0, 0, 4, 9, 0}
    };

    private final static int[][] solution = {
        {6, 8, 9, 3, 2, 5, 1, 4, 7},
        {3, 5, 4, 8, 1, 7, 9, 2, 6},
        {7, 1, 2, 6, 9, 4, 3, 8, 5},
        {2, 4, 3, 9, 7, 1, 6, 5, 8},
        {9, 7, 8, 5, 6, 3, 2, 1, 4},
        {1, 6, 5, 2, 4, 8, 7, 3, 9},
        {8, 9, 6, 4, 3, 2, 5, 7, 1},
        {4, 3, 7, 1, 5, 9, 8, 6, 2},
        {5, 2, 1, 7, 8, 6, 4, 9, 3}
    };

    public SudokuBoard generateSudokuBoard(Difficulty difficulty) {
        System.out.println("Generating sudoku board of difficulty:" + difficulty);
        SudokuGeneratorResult result = SudokuGenerator.generateUniqueSudoku(getNumberOfEmptyCells(difficulty));
        return SudokuBoard.builder()
                .values(result.getBoard())
                .solution(result.getSolution())
                .difficulty(difficulty)
                .emptyCells(result.getEmptyCells())
                .build();
    }

    private int getNumberOfEmptyCells(Difficulty difficulty) {
        Random rand = new Random();
        return rand.nextInt((difficulty.getMaxEmptyCells() - difficulty.getMinEmptyCells()) + 1) + difficulty.getMinEmptyCells();
    }
}
