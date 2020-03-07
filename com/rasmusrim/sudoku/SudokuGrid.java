package com.rasmusrim.sudoku;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.JTextField;

public class SudokuGrid {

	private JPanel sudokuPanel;
	private int size;
	
	public void update() {

		int size = this.getSize();
		JPanel sudokuGrid = this.getPanel();
		
		sudokuGrid.setLayout(new GridLayout(size, size, 0, 0));

		for (int i = 0; i < size * size; i++) {

			Color backgroundColor = this.calculateBackgroundColor(size, i);

			JPanel sudokuBox = new JPanel();
			sudokuBox.setLayout(new GridLayout(size, size, 0, 0));

			for (int j = 0; j < size * size; j++) {
				JTextField cell = new JTextField(2);
				cell.setBackground(backgroundColor);
				cell.setHorizontalAlignment(SwingConstants.CENTER);
				cell.setFont(cell.getFont().deriveFont(Font.BOLD, 14f));
				sudokuBox.add(cell);
			}
			sudokuGrid.add(sudokuBox);

		}
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
		Color grey = new Color(180, 180, 180);
		Color white = new Color(255, 255, 255);

		if (size % 2 == 0) {
			int row = (int) index / size;

			index += row;

		}

		return index % 2 == 0 ? grey : white;

	}

}
