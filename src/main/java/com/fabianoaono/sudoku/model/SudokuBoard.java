package com.fabianoaono.sudoku.model;

import com.fabianoaono.sudoku.config.Difficulty;
import jakarta.ws.rs.FormParam;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;


public class SudokuBoard {

    private int[][] values;
    private int[][] solution;

    @Parameter(
            description = "Sudoku board difficulty to create",
            name="difficulty",
            required = true
    )
    private Difficulty difficulty;

    public SudokuBoard(int[][] values, int[][] solution, Difficulty difficulty) {
        this.values = values;
        this.solution = solution;
        this.difficulty = difficulty;
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

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
