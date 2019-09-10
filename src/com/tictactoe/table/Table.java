package com.tictactoe.table;

import com.tictactoe.GameSettings.GameSettings;

public class Table {
    private GameSettings settings;

    public Table(GameSettings settings) {
        this.settings = settings;
    }

    private static final int TABLE_SIZE = 3;

    private String tableForGame[][] = new String[TABLE_SIZE][TABLE_SIZE];
    private int itemIndex = 0;

    public void showTable(){
        for(int i = 0; i < TABLE_SIZE; i ++) {
            showCell(i);
        }
    }

    private void showCell(int numberCell){
        for(int i = 0; i < TABLE_SIZE; i ++) {
            System.out.print("[" + tableForGame[i][numberCell] + "]");
        }
        System.out.println();
    }

    public void clearAllItems(){
        for(int i = 0; i < TABLE_SIZE; i ++) {
            clearCellsItems(i);
        }
    }

    private void clearCellsItems(int numberCell){
        for(int i = 0; i < TABLE_SIZE; i ++) {
            itemIndex++;
            tableForGame[i][numberCell] = itemIndex + "";
        }
    }

    public void checkVictory(int x, String name, String tool){
        int victoryMethodX = 0;
        int victoryMethodY = 0;

        for(int i = 0; i < TABLE_SIZE; i ++) {
            if (tableForGame[x][i] == tool)
                victoryMethodY++;
            if (tableForGame[i][x] == tool)
                victoryMethodX++;
        }
        if(victoryMethodY == 3 || victoryMethodX == 3 ||
                tableForGame[0][0] == tool && tableForGame[1][1] == tool && tableForGame[2][2] == tool ||
                tableForGame[2][0] == tool && tableForGame[1][1] == tool && tableForGame[0][2] == tool){
                settings.setGameFinish(false);
                settings.setWinnerName(name);
        }
    }

    public boolean checkField(int x, int y){
        boolean result;
        if(tableForGame[x][y] != "X" && tableForGame[x][y] != "O" ) {
            result = true;
        }
        else result = false;
        return result;
    }

    public void clearChooseItem(int x, int y){
        tableForGame[x][y] = " ";
    }

    public static int getTableSize() {
        return TABLE_SIZE;
    }

    public void setTableItem(int x, int y, String playerTool){
        tableForGame[x][y] = playerTool;
    }

}
