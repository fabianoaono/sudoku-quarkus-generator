package com.fabianoaono.sudoku.config;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Difficulty {
    EASY("easy", 45, 49),
    NORMAL("normal", 50, 53),
    HARD("hard", 57, 58);

    public final String difficulty;
    private final int minEmptyCells;
    private final int maxEmptyCells;

    Difficulty(String difficulty, int minEmptyCells, int maxEmptyCells) {
        this.difficulty = difficulty;
        this.minEmptyCells = minEmptyCells;
        this.maxEmptyCells = maxEmptyCells;
    }

    public static Difficulty fromString(String param) {
        String toUpper = param.toUpperCase();
        try {
            return valueOf(toUpper);
        } catch (Exception e) {
            return null;
        }
    }

    @JsonValue
    public String getDifficulty() {
        return difficulty;
    }

    public int getMinEmptyCells() {
        return minEmptyCells;
    }

    public int getMaxEmptyCells() {
        return maxEmptyCells;
    }
}
