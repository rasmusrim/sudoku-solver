package com.rasmusrim.sudoku;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Gui implements ActionListener {
	private int size;
	private Consumer<ArrayList> onSolve;
	private SudokuGrid sudokuGrid;
	private JButton btnDecreaseSize;
	private JButton btnIncreaseSize;
	
	
	public Gui(int size, Consumer<ArrayList> onSolve) {
		this.setSize(size);
		this.setOnSolve(onSolve);

	}

	public void initialize() {
		int size = this.getSize();

		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JToolBar toolbar = this.getToolbar(frame);
		toolbar.setFloatable(false);
		frame.getContentPane().add(toolbar, BorderLayout.NORTH);

		JPanel sudokuGridPanel = new JPanel();
		frame.getContentPane().add(sudokuGridPanel, BorderLayout.CENTER);

		sudokuGrid = new SudokuGrid();
		sudokuGrid.attachTo(sudokuGridPanel);
		sudokuGrid.setSize(size);
		sudokuGrid.update();
		frame.setVisible(true);

	}

	private JToolBar getToolbar(JFrame frame) {
		JToolBar toolbar = new JToolBar();

		JButton btnClear = new JButton("Clear");
		btnClear.setActionCommand("clear");
		btnClear.addActionListener(this);
		toolbar.add(btnClear);

		btnDecreaseSize = new JButton("Decrease size");
		btnDecreaseSize.setActionCommand("decreaseSize");
		btnDecreaseSize.addActionListener(this);
		toolbar.add(btnDecreaseSize);

		btnIncreaseSize = new JButton("Increase size");
		btnIncreaseSize.setActionCommand("increaseSize");
		btnIncreaseSize.addActionListener(this);
		toolbar.add(btnIncreaseSize);

		JButton btnSolve = new JButton("Solve");
		btnSolve.setActionCommand("solveSudoku");
		btnSolve.addActionListener(this);
		toolbar.add(btnSolve);

		return toolbar;

	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case "solveSudoku":
			Consumer<ArrayList> onSolve = this.getOnSolve();
			onSolve.accept(new ArrayList());
			break;
		case "increaseSize":
			increaseSize();

			break;
		case "decreaseSize":
			decreaseSize();
			break;
			
		case "clear":
			sudokuGrid.update();
		}
	}

	private void increaseSize() {
		size++;
		sudokuGrid.setSize(size);
		sudokuGrid.update();
		enableDisableSizeButtons();

	}

	private void decreaseSize() {
		size--;
		sudokuGrid.setSize(size);
		sudokuGrid.update();
		enableDisableSizeButtons();

	}
	
	private void enableDisableSizeButtons() {
		if(size == 2) {
			btnDecreaseSize.setEnabled(false);
		} else {
			btnDecreaseSize.setEnabled(true);
			
		}

		if(size == 5) {
			btnIncreaseSize.setEnabled(false);
		} else {
			btnIncreaseSize.setEnabled(true);
			
		}

		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Consumer<ArrayList> getOnSolve() {
		return onSolve;
	}

	public void setOnSolve(Consumer<ArrayList> onSolve) {
		this.onSolve = onSolve;
	}

	public SudokuGrid getSudokuGrid() {
		return sudokuGrid;
	}

	public void setSudokuGrid(SudokuGrid sudokuGrid) {
		this.sudokuGrid = sudokuGrid;
	}

}
