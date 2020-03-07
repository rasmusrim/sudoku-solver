package com.rasmusrim.sudoku;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JTextField;

public class MainGui {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int size = 3;

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("Clear");
		toolBar.add(btnNewButton);

		JButton btnIncreaseSize = new JButton("Increase size");
		toolBar.add(btnIncreaseSize);

		JButton btnDecreaseSize = new JButton("Decrease size");
		toolBar.add(btnDecreaseSize);

		JButton btnSolve = new JButton("Solve");
		toolBar.add(btnSolve);

		JPanel sudokuGrid = new JPanel();
		frame.getContentPane().add(sudokuGrid, BorderLayout.CENTER);
		sudokuGrid.setLayout(new GridLayout(size, size, 0, 0));

		for (int i = 0; i < size * size; i++) {

			Color backgroundColor = this.getBackgroundColor(size, i);

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

	private Color getRandomColor() {
		float red = (float) Math.random();
		float green = (float) Math.random();
		float blue = (float) Math.random();

		Color color = new Color(red, green, blue);

		return color;

	}

	private Color getBackgroundColor(int size, int index) {
		Color grey = new Color(180, 180, 180);
		Color white = new Color(255, 255, 255);

		if (size % 2 == 0) {
			int row = (int) index / size;

			index += row;

		}

		return index % 2 == 0 ? grey : white;

	}

}
