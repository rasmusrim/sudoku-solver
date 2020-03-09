package com.rasmusrim.sudoku.models;

public class EmptyCell extends Cell {
    public EmptyCell(int column, int row) {
        setColumn(column);
        setRow(row);
    }

    public String toString() {
        return " ";
    }

    public int getValue() {
        return 0;
    }
}
