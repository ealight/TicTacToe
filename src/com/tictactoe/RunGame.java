package com.tictactoe;

import com.tictactoe.Computer.Computer;
import com.tictactoe.GameSettings.GameSettings;
import com.tictactoe.table.Table;
import com.tictactoe.user.User;

import java.util.Scanner;


public class RunGame {
    Scanner sc = new Scanner(System.in);

    GameSettings settings = new GameSettings();
    Table table = new Table(settings);
    User user = new User(table);
    Computer computer = new Computer(table, settings);

    private int finishGame = 0;

    public void startMessage(){
        computer.setComputerName();
        System.out.println("Hello! Is game TicTacToe, please enter your name:");
        user.setUserName(sc.nextLine());
        System.out.println("Okey, your name is: " + user.getUserName() + ", your enemy name: " + computer.getComputerName());
    }

    private void setDefaultSettings(){
        table.clearAllItems();
        settings.setFindWhoFirst();
        settings.generateGameRegulations();
        System.out.println("This is a clean field:");
        table.showTable();
        settings.setGameFinish(true);
    }

    private void receiveDefaultTools(){
        System.out.println("You play for: " + settings.getUserTool() + ", "+ computer.getComputerName() + " play for: " + settings.getComuterTool());

        if(settings.getFindWhoFirst() == 0) {
            System.out.println("Uhh, sorry, " + computer.getComputerName() + " play first.");
            settings.setUserOrComputer(0);
        }
        else {
            System.out.println("Congratulation " + user.getUserName() + "! You play first!");
            settings.setUserOrComputer(1);
        }
    }

    private void startGame(){
        while(settings.isGameFinish() == true) {
            if(settings.getUserOrComputer() == 0) {
                System.out.println("The move of the: " + computer.getComputerName());

                System.out.println("---------");
                computer.randomChoseItem();
                table.setTableItem(computer.getComputerChoseRow(), computer.getComputerChoseCell(), settings.getComuterTool());
                table.showTable();
                System.out.println("---------");

                table.checkVictory(computer.getComputerChoseRow(), computer.getComputerName(), settings.getComuterTool());
                table.checkVictory(computer.getComputerChoseCell(), computer.getComputerName(), settings.getComuterTool());

                settings.setUserOrComputer(1);
                finishGame++;
            }
            else if(settings.getUserOrComputer() == 1) {
                user.enterUserItem();

                user.getUserChooseItem();

                table.setTableItem(user.getUserChoseRow(), user.getUserChoseCell(), settings.getUserTool());

                System.out.println("Your move:");

                System.out.println("---------");
                table.showTable();
                System.out.println("---------");

                table.checkVictory(user.getUserChoseRow(), user.getUserName(), settings.getUserTool());
                table.checkVictory(user.getUserChoseCell(), user.getUserName(), settings.getUserTool());

                settings.setUserOrComputer(0);
                finishGame++;
            }
            if(settings. isGameFinish() == false) {
                System.out.println("Game is end. Winner: " + settings.getWinnerName());
                break;
            }
            if(finishGame == Table.getTableSize()*Table.getTableSize()){
                settings.setGameFinish(false);
                System.out.println("Game is end. No one won!");
            }
        }
    }

    public void runGame(){
        startMessage();
        setDefaultSettings();
        receiveDefaultTools();
        startGame();
    }
}
