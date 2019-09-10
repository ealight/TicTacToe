package com.tictactoe.GameSettings;

public class GameSettings {

    private static final int MAX_RANDOM = 1;
    int MAX_RANDOM_CELL_ROW = 3;
    private String comuterTool = "NULL";
    private String userTool = "NULL";
    private String winnerName = "NULL";
    private boolean gameFinish = false;
    private int userOrComputer = -1;
    private int findWhoFirst = 0;

    public static int FindWhoFirst(int max)
    {
        return (int) (Math.random() * ++max);
    }

    public void setFindWhoFirst() {
        this.findWhoFirst = FindWhoFirst(MAX_RANDOM);
    }

    public int getFindWhoFirst() {
        return findWhoFirst;
    }

    public int getRandomCell(){
        return (int) (Math.random() * MAX_RANDOM_CELL_ROW);
    }
    public int getRandomRow(){
        return (int) (Math.random() * MAX_RANDOM_CELL_ROW);
    }

    public void setComuterTool(String comuterTool) {
        this.comuterTool = comuterTool;
    }

    public String getComuterTool() {
        return comuterTool;
    }

    public String getUserTool() {
        return userTool;
    }

    public void setUserTool(String userTool) {
        this.userTool = userTool;
    }

    public void generateGameRegulations() {
        if(FindWhoFirst(MAX_RANDOM) == 1) {
            setComuterTool("X");
            setUserTool("O");
        }
        else {
            setComuterTool("O");
            setUserTool("X");
        }
    }

    public void setGameFinish(boolean gameFinish) {
        this.gameFinish = gameFinish;
    }

    public boolean isGameFinish() {
        return gameFinish;
    }

    public String getWinnerName()
    {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public int getUserOrComputer() {
        return userOrComputer;
    }

    public void setUserOrComputer(int userOrComputer) {
        this.userOrComputer = userOrComputer;
    }
}
