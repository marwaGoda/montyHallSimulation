package com.tele2.tasks.montyhall;

import com.tele2.tasks.montyhall.game.InteractiveMontyHallGame;
import com.tele2.tasks.montyhall.game.MontyHallGame;
import com.tele2.tasks.montyhall.game.PredictiveMontyHallGame;
import com.tele2.tasks.montyhall.model.Box;
import com.tele2.tasks.montyhall.model.GameSettings;
import com.tele2.tasks.montyhall.model.GameMode;
import com.tele2.tasks.montyhall.model.Player;
import com.tele2.tasks.montyhall.model.PlayerStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameStarter {
    public static void main(String[] args) {

        // Begin GameSettings
        System.out.println("---- Welcome to monty hall TV show! ----");
        System.out.println("This a monty hall simulation that run for specific number of trials ");
        System.out.println("Let's the fun begin");

        GameSettings gameSettings = initializeGameSettings();
        MontyHallGame montyHallGame = initializeGameMode();
        initializePlayers(gameSettings, montyHallGame);
        montyHallGame.playGame(gameSettings);


        gameSettings.getPlayerList().forEach(player -> {
            System.out.println("Player " + player.getName()  +
                    " total wins: " + player.getWins() + " and total losses: " + player.getLosses());
        });

    }

    private static GameSettings initializeGameSettings() {

        GameSettings gameSettings = new GameSettings();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number of trials: ");
        gameSettings.setNumberOfTrials(scan.nextInt());
        initializeBoxes(gameSettings);

        return gameSettings;
    }


    private static MontyHallGame initializeGameMode( ) {
        System.out.println("Please enter mode of playing: ");
        Scanner scan = new Scanner(System.in);
        Arrays.asList(GameMode.values())
                .forEach(mode -> System.out.println(mode));
        int mode = getTwoChoicesUserSelection(scan);
        MontyHallGame montyHallGame = null;
        switch (mode) {
            case 1:  // play interactively
                montyHallGame = new InteractiveMontyHallGame();
                break;
            case 2:  // see choice statistics
                montyHallGame = new PredictiveMontyHallGame();
                break;
            default:
                break;
        }
        return montyHallGame;
    }

    private static void initializePlayers(GameSettings gameSettings, MontyHallGame montyHallGame) {
        System.out.println("How many players are going to play? ");
        Scanner scan = new Scanner(System.in);
        int numberOfPlayers = scan.nextInt();
        gameSettings.setNumberOfPlayers(numberOfPlayers);
        List<Player> playerList = new ArrayList<>();
        gameSettings.setPlayerList(playerList);
        for(int n = 0; n < numberOfPlayers; n++){
            Player player = new Player();
            System.out.println("Please enter details for player " + (n+1));
            System.out.println("Name:");
            player.setName(scan.next());
            if(montyHallGame instanceof PredictiveMontyHallGame){
                System.out.println("What is your playing strategy:");
                Arrays.asList(PlayerStrategy.values())
                        .forEach(strategy -> System.out.println(strategy));
                int strategy = getTwoChoicesUserSelection(scan);
                switch (strategy) {
                    case 1:  // KEEP_CHOICE
                        player.setPlayerStrategy(PlayerStrategy.KEEP_CHOICE);
                        break;
                    case 2:  // SWITCH_CHOICE
                        player.setPlayerStrategy(PlayerStrategy.SWITCH_CHOICE);
                        break;
                    default:
                        break;
                }
            }
            playerList.add(player);
        }
    }

    private static void initializeBoxes(GameSettings gameSettings) {
        List<Box> boxList = new ArrayList<>();
        gameSettings.setBoxList(boxList);
        Box firstBox = new Box(1, "Money");
        boxList.add(firstBox);
        Box secondBox = new Box(2, "Empty");
        boxList.add(secondBox);
        Box thirdBox = new Box(3, "Empty");
        boxList.add(thirdBox);
    }

    private static int getTwoChoicesUserSelection(Scanner scan) {
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
