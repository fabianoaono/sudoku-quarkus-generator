package com.fabianoaono.sudoku.resource;

import com.fabianoaono.sudoku.model.SudokuBoard;
import com.fabianoaono.sudoku.service.SudokuService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/sudoku")
public class SudokuResource {
    @Inject
    private SudokuService sudokuService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateBoard() {
        SudokuBoard generatedBoard = sudokuService.generateSudokuBoard();
        return Response.ok(generatedBoard).build();
    }
}
