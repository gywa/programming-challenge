package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the football data read from the csv file.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class FootballDataTest {

    String filename;
    private int colId;
    private int colMin;
    private int colMax;
    private char separator;

    @Before
    public void setUp() throws Exception {
        setupConfig();
    }

    // TODO no junit test => move to other place
    @Test
    public void weatherDataTest_getDataName() {

        ICollectedData collectedData;
        filename = "src/main/resources/de/exxcellent/challenge/football.csv";
        String expectedDataName = "Team";

        try {
            Reader reader = new Reader(filename, colId, colMin, colMax, separator);
            collectedData = reader.read();
            collectedData.verify();

            String receivedDataName = collectedData.getDataName();
            Assert.assertEquals("Data name", expectedDataName, receivedDataName);
        } catch (Exception e) {
            ; // do nothing?
        }
    }
    @Test
    public void footballAppTest_getIdOfMinSpread() {

        ICollectedData collectedData;
        String expectedIdOfMinSpread = "Aston_Villa";

        try {
            // FootballApp app = new FootballApp();
            Reader reader = new Reader(filename, colId, colMin, colMax, separator);
            collectedData = reader.read();
            collectedData.verify();

            String receivedIdOfMinSpread = collectedData.getIdOfMinSpread();
            Assert.assertEquals("Id of min Spread", expectedIdOfMinSpread, receivedIdOfMinSpread);

        } catch (Exception e) {
            ; // do nothing?
        }
    }
    private void setupConfig() {

        // config for .csv file containing football data
        filename = "src/main/resources/de/exxcellent/challenge/football.csv";
        int colId  = 1;
        int colMin = 7;
        int colMax = 6;
        separator = ',';
    }
}
