package com.tele2.tasks.montyhall.game;

import static com.tele2.tasks.montyhall.util.GameUtil.getBoxByNumber;
import static com.tele2.tasks.montyhall.util.GameUtil.getMoneyBox;
import static com.tele2.tasks.montyhall.util.GameUtil.getThirdBox;
import static com.tele2.tasks.montyhall.util.GameUtil.updateBoxNumbers;

import com.tele2.tasks.montyhall.model.Box;
import com.tele2.tasks.montyhall.model.GameSettings;
import com.tele2.tasks.montyhall.model.PlayerStrategy;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PredictiveMontyHallGame implements MontyHallGame{

    @Override
    public void playGame(GameSettings gameSettings) {

        Random generator = new Random();
        List<Box> boxList = gameSettings.getBoxList();
        int numberOfTrials = gameSettings.getNumberOfTrials();
        gameSettings.getPlayerList().forEach(player -> {
                System.out.println("It's " + player.getName() + " turn");
                int totalWins = 0;
                if(player.getPlayerStrategy().equals(PlayerStrategy.KEEP_CHOICE)){
                    totalWins = simulateKeepChoice(generator, numberOfTrials, boxList);
                    System.out.println("Total wins if keep first choice out of "+numberOfTrials+": "+totalWins);
                    System.out.println("Percent win: "+(double)totalWins/numberOfTrials);
                }else{
                    totalWins = simulateChangeChoice(generator, numberOfTrials, boxList);
                    System.out.println("Total wins if change first choice out of "+numberOfTrials+": "+totalWins);
                    System.out.println("Percent win: "+(double)totalWins/numberOfTrials);
                }
            player.setWins(totalWins);
            player.setLosses(numberOfTrials - totalWins);
        });



    }

    public int simulateChangeChoice(Random rng, int trials, List<Box> boxList) {
        int wins;

        System.out.println("Player always changes his mind.");
        wins = 0;
        for (int i = 1; i <= trials; i++) {
            Box moneyBox = getMoneyBox(boxList).get();
            Box userBox = getBoxByNumber(rng.nextInt(3)+1, boxList).get();
            // Here, we randomly look for boxes until
            // we find one that is wrong, yet still
            // wasn't picked by the contestant.
            Box wrongBox = getThirdBox(moneyBox, userBox, boxList).get();
            Box alternateBox = getThirdBox(userBox, wrongBox, boxList).get();

            // Always switch boxes!
            if (alternateBox == moneyBox)
                wins++;
            Collections.shuffle(boxList);
            updateBoxNumbers(boxList);
        }
        return wins;
    }

    public int simulateKeepChoice(Random rng, int trials, List<Box> boxList) {
        System.out.println("Player never changes his mind.");
        int wins = 0;
        for (int i = 1; i <= trials; i++) {
            Box moneyBox = getMoneyBox(boxList).get();
            Box userBox = getBoxByNumber(rng.nextInt(3)+1, boxList).get();

            if (userBox == moneyBox)
                wins++;
            Collections.shuffle(boxList);
        }
        return wins;
    }

}
