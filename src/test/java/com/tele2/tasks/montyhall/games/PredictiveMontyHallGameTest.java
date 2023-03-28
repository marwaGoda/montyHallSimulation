package com.tele2.tasks.montyhall.games;

import static org.junit.jupiter.api.Assertions.*;

import com.tele2.tasks.montyhall.model.Box;
import com.tele2.tasks.montyhall.model.GameSettings;
import com.tele2.tasks.montyhall.model.Player;
import com.tele2.tasks.montyhall.model.PlayerStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class PredictiveMontyHallGameTest {

    @Test
    void playGame() {
        List<Player> playerList = initializePlayers();
        List<Box> boxList = initializeBoxes();
        MontyHallGame predictiveMontyHallGame = new PredictiveMontyHallGame();
        GameSettings gameSettings = new GameSettings();
        gameSettings.setBoxList(boxList);
        gameSettings.setPlayerList(playerList);
        gameSettings.setNumberOfTrials(1000);
        predictiveMontyHallGame.playGame(gameSettings);
        assertTrue(playerList.get(0).getWins()/1000 >= 2/3);
        assertTrue(playerList.get(1).getWins()/1000 <= 1/3);

    }

    @Test
    void simulateChangeChoice() {
        int numberOfTrials = 1000;
        List<Box> boxList = initializeBoxes();
        PredictiveMontyHallGame predictiveMontyHallGame = new PredictiveMontyHallGame();
        int wins = predictiveMontyHallGame.simulateChangeChoice(new Random(), numberOfTrials, boxList);
        assertTrue(wins/1000 >= 2/3);
    }



    @Test
    void simulateKeepChoice() {
        int numberOfTrials = 1000;
        List<Box> boxList = initializeBoxes();
        PredictiveMontyHallGame predictiveMontyHallGame = new PredictiveMontyHallGame();
        int wins = predictiveMontyHallGame.simulateKeepChoice(new Random(), numberOfTrials, boxList);
        assertTrue(wins/1000 <= 1/3);
    }

    private List<Box> initializeBoxes() {
        Box firstBox = new Box(3, "none");
        Box secondBox = new Box(1, "money");
        Box thirdBox = new Box(2, "none");
        List<Box> boxList = new ArrayList<>();
        boxList.add(firstBox);
        boxList.add(secondBox);
        boxList.add(thirdBox);
        return boxList;
    }

    private List<Player> initializePlayers(){
        Player player1 = new Player();
        player1.setName("Marwa");
        player1.setPlayerStrategy(PlayerStrategy.KEEP_CHOICE);

        Player player2 = new Player();
        player2.setName("Marwa");
        player2.setPlayerStrategy(PlayerStrategy.SWITCH_CHOICE);

        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        return playerList;

    }
}