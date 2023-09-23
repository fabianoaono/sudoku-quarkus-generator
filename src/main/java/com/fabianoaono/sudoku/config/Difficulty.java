package com.fabianoaono.sudoku.config;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Difficulty {
    EASY("easy"),
    NORMAL("normal"),
    HARD("hard");

    public final String difficulty;

    Difficulty(String difficulty) {
        this.difficulty = difficulty;
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
}
