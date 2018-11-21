package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit tests for the CollectedData class.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class CollectedDataTest {

    @Before
    public void setUp() throws Exception {
        ; // nothing
    }

    @Test
    public void collectedDataTest_sortBySpread() {

        String id1 = "2";
        int minValue1 = 55;
        int maxValue1 = 85;
        String id2 = "23";
        int minValue2 = 66;
        int maxValue2 = 68;
        String expectedId = id2;
        int expectedSpread = 2;

        SingleData singleData1 = new SingleData(id1, minValue1, maxValue1);
        SingleData singleData2 = new SingleData(id2, minValue2, maxValue2);
        CollectedData collectedData = new CollectedData();
        collectedData.add(singleData1);
        collectedData.add(singleData2);
        collectedData.sortBySpread();

        String receivedId = collectedData.getIdOfMinSpread();
        Assert.assertEquals("id of min spread -", expectedId, receivedId);
    }
    @Test
    public void collectedDataTest_sortBySpread_Absolute() {

        String id1 = "1";
        int minValue1 = 55;
        int maxValue1 = 85;

        String id2 = "99";
        int minValue2 = 0;
        int maxValue2 = -5;

        String id3 = "23";
        int minValue3 = -66;
        int maxValue3 = 68;

        String expectedId = id2;

        SingleData singleData1 = new SingleData(id1, minValue1, maxValue1);
        SingleData singleData2 = new SingleData(id2, minValue2, maxValue2);
        SingleData singleData3 = new SingleData(id2, minValue3, maxValue3);
        CollectedData collectedData = new CollectedData();
        collectedData.add(singleData1);
        collectedData.add(singleData2);
        collectedData.add(singleData3);
        collectedData.sortBySpread();

        String receivedId = collectedData.getIdOfMinSpread();
        Assert.assertEquals("id of min spread -", expectedId, receivedId);
    }
}
