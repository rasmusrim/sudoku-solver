package com.rasmusrim.sudoku.models;

public class Table {
    private int size;
    private Cell[][] cells;

    public Table(int size) {
        setSize(size);
        cells = new Cell[size * size][size * size];
    }

    public String toString() {
        int sizeSquared = this.getSize() * this.getSize();
        String output = "";
        for (int column = 0; column < sizeSquared; column++) {

            for (int row = 0; row < sizeSquared; row++) {
                output += this.getCell(column, row).toString();
            }

            output += "\n";
        }

        return output;
    }

    public void addCell(int column, int row, NonEmptyCell nonEmptyCell) {
        cells[column][row] = nonEmptyCell;
    }

    public Cell getCell(int column, int row) {
        if (cells[column][row] instanceof NonEmptyCell) {
            return cells[column][row];
        } else {
            return new EmptyCell(column, row);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
