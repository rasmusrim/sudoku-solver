package com.rasmusrim.sudoku;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Gui {
	private int size;
	
	public Gui(int size) {
		this.setSize(size);
	}
	
	public void initialize() {
		int size = this.getSize();
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JToolBar toolbar = this.getToolbar(frame);
		toolbar.setFloatable( false);
		frame.getContentPane().add(toolbar, BorderLayout.NORTH);

		JPanel sudokuGrid = new JPanel();
		frame.getContentPane().add(sudokuGrid, BorderLayout.CENTER);
		
		SudokuGrid sudokuGui = new SudokuGrid();
		sudokuGui.attachTo(sudokuGrid);
		sudokuGui.setSize(size);
		sudokuGui.update();	
		frame.setVisible(true);
		

    }
    
    private JToolBar getToolbar(JFrame frame) {
		JToolBar toolbar = new JToolBar();

		JButton btnNewButton = new JButton("Clear");
		toolbar.add(btnNewButton);

		JButton btnIncreaseSize = new JButton("Increase size");
		toolbar.add(btnIncreaseSize);

		JButton btnDecreaseSize = new JButton("Decrease size");
		toolbar.add(btnDecreaseSize);

		JButton btnSolve = new JButton("Solve");
		toolbar.add(btnSolve);
		
		return toolbar;

    }

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
