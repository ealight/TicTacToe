package com.tictactoe.user;

import com.tictactoe.table.Table;

import java.util.Scanner;

public class User {

    Scanner sc = new Scanner(System.in);

    private Table table;

    private String userName = "Default";
    private int userChooseItem = -1;
    private int userChoseRow = -1;
    private int userChoseCell = -1;
    private int enterUserItem = -1;

    public User(Table table) {
        this.table = table;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserChooseItem(int userChooseItem) {
        switch(userChooseItem) {
            case 1: {
                userChoseCell = 0;
                userChoseRow = 0;
                break;
            }
            case 2: {
                userChoseCell = 0;
                userChoseRow = 1;
                break;
            }
            case 3: {
                userChoseCell = 0;
                userChoseRow = 2;
                break;
            }
            case 4: {
                userChoseCell = 1;
                userChoseRow = 0;
                break;
            }
            case 5: {
                userChoseCell = 1;
                userChoseRow = 1;
                break;
            }
            case 6: {
                userChoseCell = 1;
                userChoseRow = 2;
                break;
            }
            case 7: {
                userChoseCell = 2;
                userChoseRow = 0;
                break;
            }
            case 8: {
                userChoseCell = 2;
                userChoseRow = 1;
                break;
            }
            case 9: {
                userChoseCell = 2;
                userChoseRow = 2;
                break;
            }
        }
    }

    public int getUserChoseCell() {
        return userChoseCell;
    }

    public int getUserChoseRow() {
        return userChoseRow;
    }

    public void enterUserItem() {
        System.out.println("Enter the cell number: ");
        setUserChooseItem(sc.nextInt());
    }

    public void getUserChooseItem() {
        if(table.checkField(getUserChoseRow() , getUserChoseCell()) == false)
        {
            enterUserItem();
            getUserChooseItem();
        }
    }
}
