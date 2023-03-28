package com.tele2.tasks.montyhall.util;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tele2.tasks.montyhall.model.Box;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameUtilTest {
    @Test
    public void testGetThirdBox() {

        Box firstBox = new Box(3, "none");
        Box secondBox = new Box(1, "prize");
        Box thirdBox = new Box(2, "none");
        List<Box> boxList = new ArrayList<>();
        boxList.add(firstBox);
        boxList.add(secondBox);
        boxList.add(thirdBox);
        Box box = GameUtil.getThirdBox(firstBox, secondBox, boxList).get();
        assertEquals(2, box.getNumber());
        assertEquals("none", box.getContent());
    }

    @Test
    public void getMoneyBoxTest() {
        Box firstBox = new Box(3, "none");
        Box secondBox = new Box(1, "money");
        Box thirdBox = new Box(2, "none");
        List<Box> boxList = new ArrayList<>();
        boxList.add(firstBox);
        boxList.add(secondBox);
        boxList.add(thirdBox);
        Box box = GameUtil.getMoneyBox( boxList).get();
        assertEquals(1, box.getNumber());
        assertEquals("money", box.getContent());

    }

    @Test
    public void getBoxByNumberTest() {
        Box firstBox = new Box(3, "none");
        Box secondBox = new Box(1, "money");
        Box thirdBox = new Box(2, "none");
        List<Box> boxList = new ArrayList<>();
        boxList.add(firstBox);
        boxList.add(secondBox);
        boxList.add(thirdBox);
        Box box = GameUtil.getBoxByNumber( 2, boxList).get();
        assertEquals(2, box.getNumber());
        assertEquals("none", box.getContent());

    }

    @Test
    public void updateBoxNumbersTest(){
        Box firstBox = new Box(3, "none");
        Box secondBox = new Box(1, "money");
        Box thirdBox = new Box(2, "none");
        List<Box> boxList = new ArrayList<>();
        boxList.add(firstBox);
        boxList.add(secondBox);
        boxList.add(thirdBox);
        GameUtil.updateBoxNumbers(boxList);
        assertEquals(2, boxList.get(1).getNumber());
    }

}

