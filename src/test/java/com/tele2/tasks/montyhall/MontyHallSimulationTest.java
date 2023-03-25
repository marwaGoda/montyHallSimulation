package com.tele2.tasks.montyhall;

import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class MontyHallSimulationTest {

    @Test
    public void simulateChangeChoice() {
        int numberOfTrials = 1000;
        MontyHallSimulation montyHallSimulation = new MontyHallSimulation();
        int wins = montyHallSimulation.simulateChangeChoice(new Random(), numberOfTrials);
        Assert.assertTrue(wins/1000 >= 2/3);
    }

    @Test
    public void simulateKeepChoice() {
        int numberOfTrials = 1000;
        MontyHallSimulation montyHallSimulation = new MontyHallSimulation();
        int wins = montyHallSimulation.simulateKeepChoice(new Random(), numberOfTrials);
        Assert.assertTrue(wins/1000 <= 1/3);
    }
}