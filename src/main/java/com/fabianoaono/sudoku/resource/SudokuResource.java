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
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/sudoku")
@Tag(name="Sudoku Resouce", description="Sudoku Rest APIs")
public class SudokuResource {

    public static class Parameters {
        @RestQuery
        @Parameter(description = "Difficulty to generate")
        Difficulty difficulty;
    }
    @Inject
    private SudokuService sudokuService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "generateBoard",
            summary = "Generates a random sudoku board",
            description = "Generates a random sudoku board according to the parameters"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response generateBoard(@BeanParam Parameters parameters) {
        SudokuBoard generatedBoard = sudokuService.generateSudokuBoard(parameters.difficulty);
        return Response.ok(generatedBoard).build();
    }
}
