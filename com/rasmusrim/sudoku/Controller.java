package com.rasmusrim.sudoku;

import com.rasmusrim.sudoku.gui.Gui;
import com.rasmusrim.sudoku.models.Table;
import com.rasmusrim.sudoku.solvers.BruteForceSolver;

public class Controller {
    private Gui gui;

    public void initialize() {
        this.initializeGui(3);
    }

    private void initializeGui(int size) {
        Gui gui = new Gui(size, (Table table) -> {
            try {
                solveTable(table);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        gui.initialize();
        this.setGui(gui);
    }

    private void solveTable(Table table) throws Exception {

    	if (!table.isValid()) {
            throw new Exception("Table invalid");
        }

        BruteForceSolver solver = new BruteForceSolver(table);
        solver.setTable(table);
        Table solvedTable = solver.solve();
        System.out.println(solvedTable.toString());
    }

    public Gui getGui() {
        return gui;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }
}
