package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit tests for the SingleData class.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class SingleDataTest {

    @Before
    public void setUp() throws Exception {
        ; // nothing
    }

    @Test
    public void singleDataTest_getId() {

        int minValue = 22;
        int maxValue = 55;
        String expectedId = "testId";

        SingleData singleData = new SingleData(expectedId, minValue, maxValue);
        String receivedId = singleData.getId();
        Assert.assertEquals("getId", expectedId, receivedId);
    }
    @Test
    public void singleDataTest_getAbsoluteSpread() {

        int minValue = 22;
        int maxValue = 55;
        int expectedSpread = 33;

        SingleData singleData = new SingleData("2", minValue, maxValue);
        int receivedSpread = singleData.getAbsoluteSpread();
        Assert.assertEquals("getAbsoluteSpread", expectedSpread, receivedSpread);
    }
}
