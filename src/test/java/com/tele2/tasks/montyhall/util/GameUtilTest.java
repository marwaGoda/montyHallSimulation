package com.tele2.tasks.montyhall.util;

import org.junit.Assert;
import org.junit.Test;

public class GameUtilTest {
    @Test
    public void testGetThirdBox() {

        int firstBox = 3;
        int secondBox = 1;
        int thirdBox = GameUtil.getThirdBox(firstBox, secondBox);
        Assert.assertEquals(2, thirdBox);
    }
}
