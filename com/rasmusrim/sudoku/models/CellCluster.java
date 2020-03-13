package com.rasmusrim.sudoku.models;

import java.util.ArrayList;

public class CellCluster {

    ArrayList<Cell> cells = new ArrayList<>();

    public void add(Cell cell) {
        cells.add(cell);
    }

    public boolean isValid() {
        ArrayList<Cell> cells = getCells();
        int clusterSize = cells.size();
        for (int i = 0; i < clusterSize; i++) {
            for (int j = i + 1; j < clusterSize; j++) {
                if (cells.get(i).getValue() != -1 && cells.get(j).getValue() != -1) {
                    if (cells.get(i).getValue() == cells.get(j).getValue()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public String toString() {
        return cells.toString();
    }

}
