package com.tele2.tasks.montyhall.util;

import java.util.Random;

public class GameUtil {

    public static int getThirdBox(int firstBox, int secondBox){
        int thirdBox;
        Random generator = new Random();
        do {
            thirdBox = generator.nextInt(3) + 1;
        } while (thirdBox == firstBox || thirdBox == secondBox);
        return thirdBox;
    }

}
