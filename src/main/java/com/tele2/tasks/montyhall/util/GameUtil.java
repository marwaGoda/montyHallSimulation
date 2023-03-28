package com.tele2.tasks.montyhall.util;

import com.tele2.tasks.montyhall.model.Box;
import java.util.List;
import java.util.Optional;

public class GameUtil {

    private GameUtil(){

    }

    public static Optional<Box> getThirdBox(Box firstBox, Box secondBox, List<Box> boxList){
        for(Box box : boxList){
            if(box.getNumber() != firstBox.getNumber() && box.getNumber() != secondBox.getNumber()){
                return Optional.of(box);
            }
        }
        return Optional.empty();
    }

    public static Optional<Box> getMoneyBox(List<Box> boxList){
        for(Box box : boxList){
            if(box.getContent().equalsIgnoreCase("Money")){
                return Optional.of(box);
            }
        }
        return Optional.empty();
    }

    public static Optional<Box> getBoxByNumber(int number, List<Box> boxList){
        for(Box box : boxList){
            if(box.getNumber() == number){
                return Optional.of(box);
            }
        }
        return Optional.empty();
    }

    public static void updateBoxNumbers(List<Box> boxList){
        int index = 0;
        for(Box box : boxList){
            box.setNumber(index+1);
            index++;
        }
    }


}
