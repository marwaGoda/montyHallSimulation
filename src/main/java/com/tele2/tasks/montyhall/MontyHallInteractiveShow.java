package com.tele2.tasks.montyhall;

import static com.tele2.tasks.montyhall.util.GameUtil.getThirdBox;

import java.util.*;

public class MontyHallInteractiveShow {

    public static final char YES = 'y';
    public static final char NO = 'n';

    public void playGame(int numberOfTrials){
        // Initialize Variables
        int userBox, openBox, moneyBox;
        Random generator = new Random();
        Scanner scan = new Scanner(System.in);
        for (int n = 0; n < numberOfTrials; n++) {
            // Generate random value 1-3
            moneyBox = generator.nextInt(3) + 1;

            userBox = getUserFirstChoice(scan);

            openBox = getThirdBox( userBox, moneyBox);

            System.out.println("\nInside box number " + openBox + " there are no money!");
            System.out.println("You selected box number " + userBox);
            
            userBox = getUserSecondChoice(userBox, openBox, scan);

            System.out.println("The money is inside box number: " + moneyBox);

            if (userBox == moneyBox) {
                System.out.println("Congratulations! You won the prize!");
            } else {
                System.out.println("Sorry. You lost.");
            }
        }

    }

    

    private int getUserFirstChoice(Scanner scan) {
        int userBox;
        do {
            System.out.println("Select which box you want to open [1, 2, 3]: ");
            userBox = scan.nextInt();
            if(userBox > 3 || userBox < 0){
                System.out.println("Selection is out of range");
            }
        } while (userBox > 3 || userBox < 0);
        return userBox;
    }

    private int getUserSecondChoice(int userBox, int openBox, Scanner scan) {
        char userReply;
        do {
            System.out.println("\nWould you like to switch your box(y/n)? ");
            userReply = scan.next().charAt(0);
        } while (userReply != YES && userReply != NO);

        int userDuplicate = userBox;
        if (userReply == YES) {
            userBox = getThirdBox(openBox, userDuplicate);
        }
        return userBox;
    }


}

