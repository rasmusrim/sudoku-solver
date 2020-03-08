package com.rasmusrim.sudoku;

import java.util.ArrayList;

public class Controller {
	private Gui gui;

	public void initialize() {
		this.initializeGui(3);
	}

	private void initializeGui(int size) {
		Gui gui = new Gui(size, (ArrayList test) -> System.out.println("Callback"));
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
