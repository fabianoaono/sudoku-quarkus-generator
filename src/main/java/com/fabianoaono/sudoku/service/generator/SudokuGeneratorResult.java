package com.fabianoaono.sudoku.service.generator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class SudokuGeneratorResult {

    private int[][] board;

    private int[][] solution;

    private int emptyCells;

}
