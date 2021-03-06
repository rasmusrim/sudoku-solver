package com.rasmusrim.sudoku.gui;

import com.rasmusrim.sudoku.models.Cell;
import com.rasmusrim.sudoku.models.Table;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class SudokuGrid implements KeyListener {

    private JPanel sudokuPanel;
    private int size;
    private JTextField[][] cells;

    public void update() {

        int size = this.getSize();
        System.out.println("Updating to size " + size);

        JPanel sudokuGrid = this.getPanel();
        System.out.println(sudokuGrid.toString());
        sudokuGrid.removeAll();
        sudokuGrid.setVisible(false);
        cells = new JTextField[size * size][size * size];

        sudokuGrid.setLayout(new GridLayout(size, size, 0, 0));

        int row = 0;
        int column = 0;

        for (int i = 0; i < size * size; i++) {

            Color backgroundColor = this.calculateBackgroundColor(size, i);

            JPanel sudokuBox = new JPanel();
            sudokuBox.setLayout(new GridLayout(size, size, 0, 0));

            for (int j = 0; j < size * size; j++) {
                int boxRow = i / size;
                column = j + (i * size) - ((int) Math.floor(j / size) * size) - (size * size * boxRow);
                row = (int) (Math.floor(j / size)) + i - (i % size);

                JTextField cell = new JTextField(2);
                cell.setBackground(backgroundColor);
                cell.setHorizontalAlignment(SwingConstants.CENTER);
                cell.setFont(cell.getFont().deriveFont(Font.BOLD, 14f));
                cell.addKeyListener(this);
                cell.putClientProperty("column", column);
                cell.putClientProperty("row", row);
                //cell.setText(Integer.toString((int) Math.round(Math.random() * 8 + 1)));
                sudokuBox.add(cell);

                cells[column][row] = cell;
            }
            sudokuGrid.add(sudokuBox);
        }
        sudokuGrid.setVisible(true);

        System.out.println(cells.toString());

    }

    public Table getTable() {
        Table table = new Table(this.getSize());

        for (int column = 0; column < size * size; column++) {
            for (int row = 0; row < size * size; row++) {
                try {
                    int value = Integer.parseInt(cells[column][row].getText().trim());
                    Cell cell = new Cell();
                    cell.setValue(value);
                    cell.setColumn(column);
                    cell.setRow(row);
                    table.addCell(column, row, cell);
                } catch (NumberFormatException e) {
                }

            }

        }

        return table;
    }

    public void keyPressed(KeyEvent e) {

        JComponent source = (JComponent) e.getComponent();
        int column = (int) source.getClientProperty("column");
        int row = (int) source.getClientProperty("row");

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (row > 0) {
                    row--;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (row < size * size - 1) {
                    row++;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (column > 0) {
                    column--;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (column < size * size - 1) {
                    column++;
                }
                break;
            case KeyEvent.VK_ENTER:
                getTable();
                break;

        }

        cells[column][row].grabFocus();

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void attachTo(JPanel panel) {
        this.sudokuPanel = panel;
    }

    private JPanel getPanel() {
        return this.sudokuPanel;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    private Color calculateBackgroundColor(int size, int index) {
        Color grey = new Color(220, 220, 220);
        Color white = new Color(255, 255, 255);

        if (size % 2 == 0) {
            int row = (int) index / size;

            index += row;

        }

        return index % 2 == 0 ? grey : white;

    }

}
