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
        if (5 == number) {
            if (attempt == 1) {
                winMessage = "Congrats "+userName.toUpperCase()+", you won!"+"\nYour number of attempts = " + attempt;
                flag=false;
            } else if (attempt < 3) {
                winMessage = "Very very warm";
            } else if (attempt < 6) {
                winMessage = "Very warm";
            } else if (attempt < 10) {
                winMessage = "Warm";
            } else if (attempt < 16) {
                winMessage = "Cold";
            } else if (attempt < 21) {
                winMessage = "Very cold";
            } else if (attempt < 25) {
                winMessage = "Freezing";
            } else if (attempt < 30) {
                winMessage = "Artic";
            }
            if (flag){
                winMessage = winMessage +" "+userName.toUpperCase()+"\nYour number of attempts = " + attempt;
            }
            System.out.println(winMessage);
            return true;
        } else if (attempt == 10) {
            System.out.println("No anywhere.\n You exceeded number of attempts \n Better luck next time "+userName);
        } else{
            System.out.println("Your ");
        }
        return false;
    }

    public static void main(String[] args) {
        int attempt = 0;
        Scanner scObj = new Scanner(System.in);
        System.out.println("Welcome to Number Game\n\nPlease Enter Your Name");
        String userName = scObj.nextLine();
        System.out.println("Hi "+userName+", Are you ready to start your game? \nPlease ENTER to start or type NO for exit");
        String gameStart = scObj.nextLine();
        if (gameStart.toLowerCase()=="no") {
            System.out.println("Exit Game");
        }else{
            do {
                Scanner myObj = new Scanner(System.in);
                System.out.println("Enter a number between 1 and 100");
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

    }
}
