package com.fabianoaono.sudoku.model;

public class SudokuBoard {

    private int[][] values;
    private int[][] solution;


    public SudokuBoard(int[][] values, int[][] solution) {
        this.values = values;
        this.solution = solution;
    }


    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

    public int[][] getSolution() {
        return solution;
    }

    public void setSolution(int[][] solution) {
        this.solution = solution;
    }
}
