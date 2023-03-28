package com.tele2.tasks.montyhall.game;

import static org.junit.jupiter.api.Assertions.*;
import com.tele2.tasks.montyhall.model.Box;
import com.tele2.tasks.montyhall.model.GameSettings;
import com.tele2.tasks.montyhall.model.Player;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


class InteractiveMontyHallGameTest {

    @Test
    void playGame(){
        List<Player> playerList = initializePlayers();
        List<Box> boxList = initializeBoxes();
        MontyHallGame montyHallGame = new InteractiveMontyHallGame();
        String input = "3\ny\n2\nn";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        GameSettings gameSettings = new GameSettings();
        gameSettings.setBoxList(boxList);
        gameSettings.setPlayerList(playerList);
        gameSettings.setNumberOfTrials(1);
        montyHallGame.playGame(gameSettings);
        assertTrue(playerList.get(0).getWins()/1000 >= 2/3);
        assertTrue(playerList.get(1).getWins()/1000 <= 1/3);

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

        Player player2 = new Player();
        player2.setName("Marwa");

        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        return playerList;

    }
}