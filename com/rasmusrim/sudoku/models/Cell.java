package com.rasmusrim.sudoku.models;

public class Cell implements Cloneable {
    private int column;
    private int row;
    private int value;

    public Cell() {
        this.setValue(-1);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



}