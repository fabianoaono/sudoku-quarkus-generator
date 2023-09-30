package com.fabianoaono.sudoku.model;

import com.fabianoaono.sudoku.config.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class SudokuBoard {

    private int[][] values;

    private int[][] solution;

    private int emptyCells;

    @Parameter(
            description = "Sudoku board difficulty to create",
            name="difficulty",
            required = true
    )
    private Difficulty difficulty;
}
