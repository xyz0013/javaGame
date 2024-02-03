package com.Oliver;

import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    static int money = 100;
    static String[] monsters = {"Grade 5 Monster", "Grade 4 Monster", "Grade 3 Monster", "Grade 2 Monster", "Grade 1 Monster", "Special Grade Monster"};
    static String[] rareMonsters = {"Super Monster", "Mega Monster", "Grade 19 Monster", "Awesome Monster"};
    static String[] inventory = {"None", "None", "None", "None", "None"};
    public static void main(String[] args) {
        int m = money;
        int cost = 20;
        LocalTime currentTime = LocalTime.now();
        while (true) {
            int income = 0;
            for (String string : inventory) {
                if (string.equals("Grade 5 Monster")) {
                    income += 2;
                }
                if (string.equals("Grade 4 Monster")) {
                    income += 4;
                }
                if (string.equals("Grade 3 Monster")) {
                    income += 8;
                }
                if (string.equals("Grade 2 Monster")) {
                    income += 16;
                }
                if (string.equals("Grade 1 Monster")) {
                    income += 18;
                }
                if (string.equals("Special Grade Monster")) {
                    income += 19;
                }
                if (string.equals("Super Monster")) {
                    income += 20;
                }
                if (string.equals("Mega Monster")) {
                    income += 57;
                }
                if (string.equals("Grade 19 Monster")) {
                    income -= 1;
                }
                if (string.equals("Awesome Monster")) {
                    income += 123;
                }
                if (string.equals("Skelly Monster")) {
                    income += 938;
                }
            }
            System.out.println("Income: " + income);
            System.out.println("You have $" + m + ".");
            System.out.println("1. Buy a pack for $" + cost);
            System.out.println("2. See monsters");
            System.out.println("3. Gain money");
            System.out.println("4. Talk to floating skeleton");
            Scanner input = new Scanner(System.in);
            System.out.print(">>> ");
            String q = input.nextLine().trim();
            int min = 0;
            int max = monsters.length;
            int min2 = 0;
            int max2 = rareMonsters.length;
            int randomNum = (int) Math.floor(Math.random() * (max - min + 1) + min);
            int randomNum2 = (int) Math.floor(Math.random() * (max2 - min2 + 1) + min2);

            if (randomNum == 0) {
                randomNum++;
            }
            if (randomNum2 == 0) {
                randomNum2++;
            }
            String resultDecider = monsters[randomNum - 1];
            String specialResult = rareMonsters[randomNum2 - 1];
            if (Integer.parseInt(q) == 1 && currentTime.getHour() == 17 && m >= cost) {



                m -= cost;
                for (String s : inventory) {
                    System.out.println(s);
                }
                System.out.println("You bought a pack for $" + cost + ". You got a " + specialResult + "!");
                cost += 2 * (inventory.length - 1);
                Scanner wantToSave = new Scanner(System.in);
                System.out.print("Do you want to save this monster (y/n)? ");
                String wantToSaveResult = wantToSave.nextLine().trim();
                if (wantToSaveResult.equals("y")) {
                    Scanner whichSlotToSaveIn = new Scanner(System.in);
                    System.out.print("Which slot do you want to save this monster in (1-5)? ");
                    String whichToSaveInResult = whichSlotToSaveIn.nextLine().trim();
                    inventory[Integer.parseInt(whichToSaveInResult) - 1] = specialResult;
                }



            }
            if (Integer.parseInt(q) == 1 && m >= cost && currentTime.getHour() != 17) {
                m -= cost;
                for (String s : inventory) {
                    System.out.println(s);
                }
                System.out.println("You bought a pack for $" + cost + ". You got a " + resultDecider + "!");
                cost += 2 * (inventory.length - 1);
                Scanner wantToSave = new Scanner(System.in);
                System.out.print("Do you want to save this monster (y/n)? ");
                String wantToSaveResult = wantToSave.nextLine().trim();
                if (wantToSaveResult.equals("y")) {
                    Scanner whichSlotToSaveIn = new Scanner(System.in);
                    System.out.print("Which slot do you want to save this monster in (1-5)? ");
                    String whichToSaveInResult = whichSlotToSaveIn.nextLine().trim();
                    inventory[Integer.parseInt(whichToSaveInResult) - 1] = resultDecider;
                }
            } else if (Integer.parseInt(q) == 1 && m < cost) {
                System.out.println("You don't have enough money!");
            }
            if (Integer.parseInt(q) == 2) {
                for (String s : inventory) {
                    System.out.println(s);
                }
            }
            if (Integer.parseInt(q) == 3) {
                m += income;

            }
            if (Integer.parseInt(q) == 4) {
                if (m > 10000) {
                    System.out.println("You are worthy.");
                    Scanner scan = new Scanner(System.in);
                    System.out.print("What is my favorite color? ");
                    String sScan = scan.nextLine().trim();
                    if (sScan.equals("Red")) {
                        Scanner scan2 = new Scanner(System.in);
                        System.out.println("What is my name? ");
                        String sScan2 = scan2.nextLine().trim();
                        if (sScan2.equals("Floating Skeleton")) {
                            System.out.println("You obtained: Skelly Monster! It went to slot 1.");
                            inventory[0] = "Skelly Monster";
                        }
                    }
                } else {
                    System.out.println("You are not worthy (broke).");
                }
            }
            if (q.equals("exit")) {
                System.exit(0);
            }
        }
    }

}
