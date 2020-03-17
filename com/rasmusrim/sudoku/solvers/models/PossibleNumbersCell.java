package com.rasmusrim.sudoku.solvers.models;

import java.util.HashSet;
import java.util.Set;

public class PossibleNumbersCell {
    private Set<Integer> possibleNumbers = new HashSet();

    public PossibleNumbersCell(int size) {
        for (int i = 1; i <= size; i++) {
            possibleNumbers.add(i);
        }
    }

    public void remove(int value) {
        possibleNumbers.remove(value);
    }

    public void removeAllExcept(int value) {
        possibleNumbers.clear();
        possibleNumbers.add(value);
    }

    public String toString() {
        return possibleNumbers.toString();
    }

    public boolean onlyOnePossible() {
        return possibleNumbers.size() == 1;
    }

}
