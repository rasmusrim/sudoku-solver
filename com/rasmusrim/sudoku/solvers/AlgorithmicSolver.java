package com.rasmusrim.sudoku.solvers;

import com.rasmusrim.sudoku.models.Cell;
import com.rasmusrim.sudoku.models.CellCluster;
import com.rasmusrim.sudoku.models.Table;
import com.rasmusrim.sudoku.solvers.models.PossibleNumbersCell;

public class AlgorithmicSolver implements Solver {
    private Table table;
    private PossibleNumbersCell[][] possibleNumbersGrid;
    private int squaredSize;

    public AlgorithmicSolver(Table table) {
        setTable(table);
        setSquaredSize(table.getSize() * table.getSize());
    }

    public Table solve() {
        PossibleNumbersCell[][] possibleNumbersGrid = generatePossibleNumbersGrid(getTable().getSize());
        setPossibleNumbersGrid(possibleNumbersGrid);

        Table table = getTable();
        int squaredSize = getSquaredSize();

//        while (table.hasEmptyCell()) {
        for (int i = 0; i < squaredSize; i++) {
            CellCluster row = table.getRow(i);
            CellCluster column = table.getColumn(i);
            //CellCluster box = table.getBox(i);

            removeAlreadyExistingNumbersFromOtherCellsInCluster(row);
            removeAlreadyExistingNumbersFromOtherCellsInCluster(column);
            //removeAlreadyExistingNumbersFromOtherCellsInCluster(box);

        }

        output();
        //      }

        return table;
    }

    private void removeAlreadyExistingNumbersFromOtherCellsInCluster(CellCluster cluster) {

        for (int i = 0; i < getSquaredSize(); i++) {
            Cell cell = cluster.getCell(i);
            PossibleNumbersCell possibleNumbersCell = possibleNumbersGrid[cell.getColumn()][cell.getRow()];

            if (cell.getValue() != -1) {
                possibleNumbersCell.removeAllExcept(cell.getValue());

                for (int j = 0; j < getSquaredSize(); j++) {
                    if (j != i) {
                        Cell cell2 = cluster.getCell(j);

                        PossibleNumbersCell possibleNumbersCell2 = possibleNumbersGrid[cell2.getColumn()][cell2.getRow()];
                        possibleNumbersCell2.remove(cell.getValue());
                    }
                }
            }
        }

    }

    private void output() {
        int squaredSize = getSquaredSize();
        PossibleNumbersCell[][] possibleNumbersGrid = getPossibleNumbersGrid();

        for (int row = 0; row < squaredSize; row++) {
            for (int column = 0; column < squaredSize; column++) {
                System.out.print(possibleNumbersGrid[column][row].toString() + " | ");
            }

            System.out.println("\n");
        }
    }

    private PossibleNumbersCell[][] generatePossibleNumbersGrid(int size) {
        int squaredSize = size * size;
        PossibleNumbersCell[][] possibleNumbersGrid = new PossibleNumbersCell[squaredSize][squaredSize];

        for (int column = 0; column < squaredSize; column++) {
            for (int row = 0; row < squaredSize; row++) {
                possibleNumbersGrid[column][row] = new PossibleNumbersCell(squaredSize);
            }

        }

        return possibleNumbersGrid;

    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public PossibleNumbersCell[][] getPossibleNumbersGrid() {
        return possibleNumbersGrid;
    }

    public void setPossibleNumbersGrid(PossibleNumbersCell[][] possibleNumbersGrid) {
        this.possibleNumbersGrid = possibleNumbersGrid;
    }

    public int getSquaredSize() {
        return squaredSize;
    }

    public void setSquaredSize(int squaredSize) {
        this.squaredSize = squaredSize;
    }
}
