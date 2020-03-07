package com.rasmusrim.sudoku;

public class Solver {
	private Gui gui;

	public void initialize() {
		this.initializeGui(5);
	}

	private void initializeGui(int size) {
		Gui gui = new Gui(size);
		gui.initialize();
		this.setGui(gui);
	}

	public Gui getGui() {
		return gui;
	}

	public void setGui(Gui gui) {
		this.gui = gui;
	}
}
