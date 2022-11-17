package com.nology.numbergame;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public boolean play(int number, int attempt, String userName) {
        String winMessage = "";
        boolean flag=true;
        Random rand = new Random();
        int randomNum = rand.nextInt(101);
        //System.out.println(attempt + " and given=" + number);
        if (randomNum == number) {
            if (attempt == 1) {
                winMessage = "Congrats "+userName.toUpperCase()+", You Won!"+"\nNumber Of Attempts = " + attempt;
                flag=false;
            } else if (attempt < 3) {
                winMessage = "Very Very Warm";
            } else if (attempt < 6) {
                winMessage = "Very Warm";
            } else if (attempt < 10) {
                winMessage = "Warm";
            } else if (attempt < 16) {
                winMessage = "Cold";
            } else if (attempt < 21) {
                winMessage = "Very Cold";
            } else if (attempt < 25) {
                winMessage = "Freezing";
            } else if (attempt < 30) {
                winMessage = "Artic";
            }
            if (flag){
                winMessage = winMessage +" "+userName.toUpperCase()+"\nYou Won This Game On " + attempt+" Attempts";
            }
            System.out.println("----------------------------------------\n\n"+winMessage+"\n\n----------------------------------------\n");
            return true;
        } else if (attempt == 10) {
            System.out.println("No anywhere.\n You exceeded number of attempts \n Better luck next time "+userName);
        } else{
            System.out.println("Sorry! Mismatching..Please Try Again ");
        }
        return false;
    }

    public void setPlay(String userName) {
        int attempt = 0;
        do {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter A Number Between 1 And 100");
            String number = myObj.nextLine();
            int num;
            try {
                num = Integer.parseInt(number);
                attempt++;
                NumberGame obj = new NumberGame();
                if (obj.play(num, attempt, userName)) {
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number");
                attempt++;
            }
        } while (attempt < 10);
    }

    public static void main(String[] args) {
        Scanner scObj = new Scanner(System.in);
        System.out.println("Welcome to Number Game\n\nPlease Enter Your Name");
        String userName = scObj.nextLine();
        System.out.println("Hi "+userName.toUpperCase()+", Are you ready to start your game? \nPlease ENTER to start or type NO for exit");
        String gameStart = scObj.nextLine();
        if (gameStart.toLowerCase()=="no") {
            System.out.println("Exit Game");
        }else{
            NumberGame obj = new NumberGame();
            obj.setPlay(userName);
        }

    }
}
