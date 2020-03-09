package com.rasmusrim.sudoku.models;

public class NonEmptyCell extends Cell {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
