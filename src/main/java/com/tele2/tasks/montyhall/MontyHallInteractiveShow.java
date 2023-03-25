package com.tele2.tasks.montyhall;

import static com.tele2.tasks.montyhall.util.GameUtil.getThirdBox;

import java.util.*;

public class MontyHallInteractiveShow {

    public void playGame(int numberOfTrials){
        // Initialize Variables
        int userBox, openBox, moneyBox;
        Random generator = new Random();
        Scanner scan = new Scanner(System.in);
        for (int n = 0; n < numberOfTrials; n++) {
            // Generate random value 1-3
            moneyBox = generator.nextInt(3) + 1;

            userBox = getUserBox(scan);

            openBox = getThirdBox( userBox, moneyBox);

            System.out.println("\nInside box number " + openBox + " there are no money!");
            System.out.println("You selected box number " + userBox);
            char userReply;
            do {
                System.out.println("\nWould you like to switch your box(y/n)? ");
                userReply = scan.next().charAt(0);
            } while (userReply != 'y' && userReply != 'n');

            int userDuplicate = userBox;
            if (userReply == 'y') {
                userBox = getThirdBox(openBox, userDuplicate);
            }

            System.out.println("The money is inside box number: " + moneyBox);

            if (userBox == moneyBox) {
                System.out.println("Congratulations! You won the prize!");
            } else {
                System.out.println("Sorry. You lost.");
            }
        }

    }

    private int getUserBox(Scanner scan) {
        int userBox;
        do {
            System.out.println("Select the box (1, 2, 3): ");
            userBox = scan.nextInt();
            if(userBox > 3 || userBox < 0){
                System.out.println("Selection is out of range");
            }
        } while (userBox > 3 || userBox < 0);
        return userBox;
    }


}

