package com.tele2.tasks.montyhall;

import java.util.Scanner;

public class MontyHallGameShow {
    public static void main(String[] args) {

        // Begin Game
        System.out.println("---- Welcome to monty hall TV show! ----");
        System.out.println("This a monty hall simulation that run for specific number of trials ");


        System.out.println("Please enter mode of playing:  1. Interactive mode  2. Predictive mode");
        Scanner scan = new Scanner(System.in);
        int mode = getModeSelection(scan);
        System.out.println("Please enter the number of trials: ");
        int numberOfTrials = scan.nextInt();

        switch (mode) {
            case 1:  // play interactively
                MontyHallInteractiveShow montyHallInteractiveShow = new MontyHallInteractiveShow();
                montyHallInteractiveShow.playGame(numberOfTrials);
                break;
            case 2:  // see choice statistics
                MontyHallSimulation montyHallSimulation = new MontyHallSimulation();
                montyHallSimulation.runSimulation(numberOfTrials);
                break;
            default:
                break;
        }

    }
    private static int getModeSelection(Scanner scan) {
        int mode;
        do {
            mode = scan.nextInt();
            if(mode > 2 || mode < 1){
                System.out.println("Selection is out of range");
            }
        } while (mode > 2 || mode < 1);
        return mode;
    }

}
