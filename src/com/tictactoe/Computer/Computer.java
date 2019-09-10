package com.tictactoe.Computer;

import com.tictactoe.GameSettings.GameSettings;
import com.tictactoe.table.Table;

public class Computer {

    private static final String[] computerNameSample = new String[] {"Lubart", "John", "Samuel", "Albert", "Dmytro", "Jan-Jack"};
    private static String computerName = null;
    private int computerChoseCell = -1;
    private int computerChoseRow = -1;
    private Table table;
    private GameSettings settings;

    public Computer(Table table, GameSettings settings) {
        this.table = table;
        this.settings = settings;
    }

    public void randomChoseItem(){
        int randomRow = -1 , randomCell = - 1;

        randomRow = settings.getRandomRow();
        randomCell = settings.getRandomCell();

        if(table.checkField(randomRow, randomCell) == false) {
            randomChoseItem();
        }
        else {
            setComputerChoseRow(randomRow);
            setComputerChoseCell(randomCell);
        }

    }
    public int getComputerChoseCell() {
        return computerChoseCell;
    }

    public void setComputerChoseCell(int computerChoseCell) {
        this.computerChoseCell = computerChoseCell;
    }

    public int getComputerChoseRow() {
        return computerChoseRow;
    }

    public void setComputerChoseRow(int computerChoseRow) {
        this.computerChoseRow = computerChoseRow;
    }

    public void setComputerName(){
        computerName = computerNameSample[settings.FindWhoFirst(computerNameSample.length-1)];
    }

    public static String getComputerName() {
        return computerName;
    }

}
