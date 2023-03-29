package com.tele2.tasks.montyhall.util;

import com.tele2.tasks.montyhall.model.Box;
import java.util.List;
import java.util.Optional;

public class GameUtil {

    public static final String MONEY = "Money";

    private GameUtil(){

    }

    public static Optional<Box> getThirdBox(Box firstBox, Box secondBox, List<Box> boxList){
        return boxList.stream().filter(
                box -> (box.getNumber() != firstBox.getNumber() && box.getNumber() != secondBox.getNumber()))
                .findFirst();
    }

    public static Optional<Box> getMoneyBox(List<Box> boxList){
        return boxList.stream().filter(
                box -> (box.getContent().equalsIgnoreCase(MONEY)))
                .findFirst();
    }

    public static Optional<Box> getBoxByNumber(int number, List<Box> boxList){
        return boxList.stream().filter(
                box -> (box.getNumber() == number))
                .findFirst();
    }

    public static void updateBoxNumbers(List<Box> boxList){
        int index = 0;
        for(Box box : boxList){
            box.setNumber(index+1);
            index++;
        }
    }


}
