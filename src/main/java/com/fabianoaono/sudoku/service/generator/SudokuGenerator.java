package com.fabianoaono.sudoku.service.generator;

import java.util.Random;

public class SudokuGenerator {

    public static SudokuGeneratorResult generateUniqueSudoku(int emptyCells) {

        int[][] board = new int[9][9];
        Random rand = new Random();

        // Generate a completed Sudoku solution
        int[][] solution = new int[9][9];
        solveSudoku(solution);

        // Randomly shuffle rows and columns to create a unique Sudoku solution
        shuffleRows(solution, rand);
        transpose(solution);
        shuffleRows(solution, rand);

        // Copy the solution to the board
        for (int i = 0; i < 9; i++) {
            System.arraycopy(solution[i], 0, board[i], 0, 9);
        }

        int cellsToRemove = emptyCells;
        // Remove numbers to create the game board with the specified difficulty
        while (cellsToRemove > 0) {
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);

            if (board[row][col] != 0) {
                board[row][col] = 0;
                cellsToRemove--;
            }
        }

        return SudokuGeneratorResult.builder()
                .board(board)
                .solution(solution)
                .emptyCells(emptyCells)
                .build();
    }

    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void shuffleRows(int[][] board, Random rand) {
        for (int i = 0; i < 3; i++) {
            int group1 = rand.nextInt(3);
            int group2 = rand.nextInt(3);
            if (group1 != group2) {
                int offset1 = group1 * 3;
                int offset2 = group2 * 3;
                for (int j = 0; j < 3; j++) {
                    int[] temp = board[offset1 + j];
                    board[offset1 + j] = board[offset2 + j];
                    board[offset2 + j] = temp;
                }
            }
        }
    }

    private static void transpose(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int temp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = temp;
            }
        }
    }

    public static void printSudokuBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
