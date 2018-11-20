package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    @Before
    public void setUp() throws Exception {
        ;
    }

    // TODO no junit test => move to other place
    @Test
    public void footballAppTest_getIdOfMinSpread() {

        ICollectedData collectedData;
        String expectedIdOfMinSpread = "Aston_Villa";
        String filename_OK = "src/main/resources/de/exxcellent/challenge/weather.csv";
        String filename    = "src/main/resources/de/exxcellent/challenge/football.csv";
        int colId  = 1;
        int colMin = 7;
        int colMax = 6;
        char separator = ',';

        try {
            App app = new App();
            Reader reader = new Reader(filename, colId, colMin, colMax, separator);
            collectedData = app.reader.read(); // app.reader.read();
            collectedData.verify();

            String receivedIdOfMinSpread = collectedData.getIdOfMinSpread();
            Assert.assertEquals("Id of min Spread", expectedIdOfMinSpread, receivedIdOfMinSpread);
        } catch (Exception e) {
            ; // do nothing
        }
    }

}
