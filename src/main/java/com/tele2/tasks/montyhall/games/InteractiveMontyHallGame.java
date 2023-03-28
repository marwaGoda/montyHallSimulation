package com.tele2.tasks.montyhall.games;

import static com.tele2.tasks.montyhall.util.GameUtil.getMoneyBox;
import static com.tele2.tasks.montyhall.util.GameUtil.getThirdBox;
import static com.tele2.tasks.montyhall.util.GameUtil.updateBoxNumbers;

import com.tele2.tasks.montyhall.model.Box;
import com.tele2.tasks.montyhall.model.GameSettings;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InteractiveMontyHallGame implements MontyHallGame{

    private static final char YES = 'y';
    private static final char NO = 'n';

    @Override
    public void playGame(GameSettings gameSettings) {
        List<Box> boxList = gameSettings.getBoxList();
        Scanner scanner = getScanner();
        gameSettings.getPlayerList().forEach(player -> {
            System.out.println("It's " + player.getName() + " turn");
            int wins = 0;
            int losses = 0;
            for (int n = 0; n < gameSettings.getNumberOfTrials(); n++) {
                Collections.shuffle(boxList);
                updateBoxNumbers(boxList);

                Box moneyBox = getMoneyBox(boxList).get();

                Box userBox = boxList.get(getUserFirstChoice(scanner) - 1);

                Box openBox = getThirdBox(userBox, moneyBox, boxList).get();

                System.out.println("\nInside box number " + openBox.getNumber() + " there are no money!");
                System.out.println("You selected box number " + userBox.getNumber());

                userBox = getUserSecondChoice(userBox, openBox, boxList, scanner);

                System.out.println("The money is inside box number: " + moneyBox.getNumber());

                if (userBox == moneyBox) {
                    System.out.println("Congratulations! You won the prize!");
                    wins++;
                } else {
                    System.out.println("Sorry. You lost.");
                    losses++;
                }
            }
            player.setLosses(losses);
            player.setWins(wins);
        });

    }

    protected Scanner getScanner() {
        Scanner scanner = new Scanner(System.in);
       return scanner;
    }
    private int getUserFirstChoice(Scanner scanner) {
        int userBox;
        do {
            System.out.println("Select which box you want to open [1, 2, 3]: ");
            userBox = scanner.nextInt();
            if(userBox > 3 || userBox < 0){
                System.out.println("Selection is out of range");
            }
        } while (userBox > 3 || userBox < 0);
        return userBox;
    }

    private Box getUserSecondChoice(Box userBox, Box openBox, List<Box> boxList, Scanner scanner) {
        char userReply;
        do {
            System.out.println("\nWould you like to switch your box(y/n)? ");
            userReply = scanner.next().charAt(0);
        } while (userReply != YES && userReply != NO);

        Box userDuplicate = userBox;
        if (userReply == YES) {
            userBox = getThirdBox(openBox, userDuplicate, boxList).get();
        }
        return userBox;
    }

}
