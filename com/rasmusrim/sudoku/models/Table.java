package com.rasmusrim.sudoku.models;

public class Table implements Cloneable {
    private int size;
    private Cell[][] cells;

    public Table(int size) {
        setSize(size);
        cells = new Cell[size * size][size * size];

        int sizeSquared = getSize() * getSize();
        for (int column = 0; column < sizeSquared; column++) {
            for (int row = 0; row < sizeSquared; row++) {
                Cell cell = new Cell();
                cell.setColumn(column);
                cell.setRow(row);
                this.addCell(column, row, cell);

            }

        }
    }

    public boolean isValid() {
        int sizeSquared = this.getSize() * this.getSize();
        for (int i = 0; i < sizeSquared; i++) {
            CellCluster row = getRow(i);

            if (!row.isValid()) {
                return false;
            }

            CellCluster column = getColumn(i);
            if (!column.isValid()) {
                return false;
            }
        }

        for (int column = 0; column < getSize(); column++) {
            for (int row = 0; row < getSize(); row++) {
                CellCluster box = getBox(column, row);
                if (!box.isValid()) {
                    return false;
                }
            }
        }

        return true;

    }

    public boolean hasEmptyCell() {
        int sizeSquared = this.getSize() * this.getSize();

        for (int row = 0; row < sizeSquared; row++) {

            for (int column = 0; column < sizeSquared; column++) {
                Cell cell = this.getCell(column, row);
                if (cell.getValue() == -1) {
                    return true;
                }
            }
        }

        return false;

    }


    public String toString() {
        int sizeSquared = this.getSize() * this.getSize();
        String output = "";
        for (int row = 0; row < sizeSquared; row++) {

            for (int column = 0; column < sizeSquared; column++) {

                if (column % size == 0) {
                    output += " || ";
                } else {
                    output += " | ";
                }

                output += this.getCell(column, row).toString();
            }

            output += " ||\n";
        }

        return output;
    }

    public CellCluster getBox(int column, int row) {
        if (column > size || row > size) {
            throw new IndexOutOfBoundsException("Column or row larger than table size");
        }

        CellCluster box = new CellCluster();

        int startColumn = column * getSize();
        int endColumn = startColumn + getSize() - 1;

        int startRow = row * getSize();
        int endRow = startRow + getSize() - 1;

        for (int columnIndex = startColumn; columnIndex <= endColumn; columnIndex++) {
            for (int rowIndex = startRow; rowIndex <= endRow; rowIndex++) {
                box.add(this.getCell(columnIndex, rowIndex));
            }
        }

        return box;
    }

    public CellCluster getRow(int rowIndex) {
        CellCluster row = new CellCluster();
        for (int columnIndex = 0; columnIndex < getSize() * getSize(); columnIndex++) {
            row.add(this.getCell(columnIndex, rowIndex));
        }

        return row;
    }

    public CellCluster getColumn(int columnIndex) {
        CellCluster column = new CellCluster();
        for (int rowIndex = 0; rowIndex < getSize() * getSize(); rowIndex++) {
            column.add(this.getCell(columnIndex, rowIndex));
        }

        return column;
    }

    public Object clone() throws CloneNotSupportedException {
        Table clonedTable = new Table(getSize());
        int squaredSize = getSize() * getSize();
        for (int columnIndex = 0; columnIndex < squaredSize; columnIndex++) {
            for (int rowIndex = 0; rowIndex < squaredSize; rowIndex++) {
                clonedTable.addCell(columnIndex, rowIndex, (Cell) this.getCell(columnIndex, rowIndex).clone());

            }
        }

        return clonedTable;

    }

    public void addCell(int column, int row, Cell cell) {
        cells[column][row] = cell;
    }

    public Cell getCell(int column, int row) {
        return cells[column][row];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
