package com.rasmusrim.sudoku.solvers;

import com.rasmusrim.sudoku.models.Cell;
import com.rasmusrim.sudoku.models.CellCluster;
import com.rasmusrim.sudoku.models.Table;

public class BruteForceSolver implements Cloneable {

    private Table table;

    public BruteForceSolver(Table table) {
        setTable(table);
    }

    public Table solve() throws CloneNotSupportedException {
        int size = table.getSize();
        int sizeSquared = size * size;
        Table clonedTable;

        clonedTable = (Table) table.clone();
        int attempt = 0;

        while(true) {
            attempt++;
            System.out.println("Attempt " + attempt);
            for (int column = 0; column < sizeSquared; column++) {
                for (int row = 0; row < sizeSquared; row++) {
                    Cell cell = clonedTable.getCell(column, row);
                    if (cell.getValue() == -1) {
                        int randomValue = (int) Math.round(Math.random() * (sizeSquared - 1) + 1);
                        cell.setValue(randomValue);
                    }
                }

            }

            if (clonedTable.isValid()) {
                break;
            }

        }

        return clonedTable;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
