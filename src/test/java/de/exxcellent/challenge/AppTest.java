package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    private String successLabel = "not successful";

    @Before
    public void setUp() throws Exception {
        successLabel = "successful";
    }

    @Test
    public void aPointlessTest() {
        Assert.assertEquals("Expectations met", "successful", successLabel);
    }
    @Test
    public void readerTest_noExcp_FileNotFound() {

        boolean exceptionExpected = false;
        boolean exceptionReceived = false;

        String filename_OK = "src/main/resources/de/exxcellent/challenge/weather.csv";
        //public static final String FILENAME_OK = "src/main/resources/de/exxcellent/challenge/weather.csv";
        try {
            App app = new App();
            app.reader.read(filename_OK);
            Assert.assertEquals("FileNotFoundException", exceptionExpected, exceptionReceived);

        } catch (FileNotFoundException e) {
            ; // do nothing
        }
    }
    @Test
    public void readerTest_excp_FileNotFound() {

        boolean exceptionExpected = true;
        boolean exceptionReceived = false;

        String filename_NOTOK = "src/main/resources/de/exxcellent/challenge/noweather.csv";
        try {
            App app = new App();
            app.reader.read(filename_NOTOK);

        } catch (FileNotFoundException e) {
            exceptionReceived = true;
            Assert.assertEquals("FileNotFoundException", exceptionExpected, exceptionReceived);
        }
    }
}
