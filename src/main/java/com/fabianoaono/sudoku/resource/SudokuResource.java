package com.fabianoaono.sudoku.resource;

import com.fabianoaono.sudoku.config.Difficulty;
import com.fabianoaono.sudoku.model.SudokuBoard;
import com.fabianoaono.sudoku.service.SudokuService;
import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/sudoku")
public class SudokuResource {

    public static class Parameters {
        @RestQuery
        Difficulty difficulty;
    }
    @Inject
    private SudokuService sudokuService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateBoard(@BeanParam Parameters parameters) {
        SudokuBoard generatedBoard = sudokuService.generateSudokuBoard(parameters.difficulty);
        return Response.ok(generatedBoard).build();
    }
}
