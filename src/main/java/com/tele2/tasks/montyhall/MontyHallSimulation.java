package com.tele2.tasks.montyhall;

import static com.tele2.tasks.montyhall.util.GameUtil.getThirdBox;

import java.util.Random;

public class MontyHallSimulation {

    public  void runSimulation(int numberOfTrials) {

        Random generator = new Random();

        int keepWins = simulateKeepChoice(generator, numberOfTrials);
        System.out.println("Total wins if keep first choice out of "+numberOfTrials+": "+keepWins);
        System.out.println("Percent win: "+(double)keepWins/numberOfTrials);

        int changeWins = simulateChangeChoice(generator, numberOfTrials);
        System.out.println("Total wins if change first choice out of "+numberOfTrials+": "+changeWins);
        System.out.println("Percent win: "+(double)changeWins/numberOfTrials);
    }

    public int simulateChangeChoice(Random rng, int trials) {
        int wins;

        System.out.println("Player always changes his mind.");
        wins = 0;
        for (int i = 1; i <= trials; i++) {
            int moneyBox = rng.nextInt(3)+1;
            int userBox = rng.nextInt(3)+1;
            // Here, we randomly look for boxes until
            // we find one that is wrong, yet still
            // wasn't picked by the contestant.
            int wrongBox = getThirdBox(moneyBox, userBox);
            int alternateBox = getThirdBox(userBox, wrongBox);

            // Always switch boxes!
            if (alternateBox == moneyBox)
                wins++;
        }
        return wins;
    }

    public int simulateKeepChoice(Random rng, int trials) {
        System.out.println("Player never changes his mind.");
        int wins = 0;
        for (int i = 1; i <= trials; i++) {
            int moneyBox = rng.nextInt(3)+1 ;
            int userBox = rng.nextInt(3)+1 ;

            if (userBox == moneyBox)
                wins++;
        }
        return wins;
    }


}
