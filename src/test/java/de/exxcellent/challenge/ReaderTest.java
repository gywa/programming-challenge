package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Tests for the Reader class. 'weather.csv' is required.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class ReaderTest {

    String filename;
    private int colId;
    private int colMin;
    private int colMax;
    private char separator;

    @Before
    public void setUp() throws Exception {

        setup_weatherConfig();
    }
    @Test
    public void readerTest_noExcp_FileNotFound() {

        boolean exceptionExpected = false;
        boolean exceptionReceived = true;

        String filename_OK = "src/main/resources/de/exxcellent/challenge/weather.csv";
        try {
            Reader reader = new Reader(filename_OK, colId, colMin, colMax, separator);
            reader.read();
            exceptionReceived = false;

        } catch (FileNotFoundException e) {
            exceptionReceived = true;
        }
        Assert.assertEquals("no FileNotFoundException", exceptionExpected, exceptionReceived);
    }
    @Test
    public void readerTest_excp_FileNotFound() {

        boolean exceptionExpected = true;
        boolean exceptionReceived = false;

        String filename_NOTOK = "src/main/resources/de/exxcellent/challenge/noweather.csv";
        try {
            Reader reader = new Reader(filename_NOTOK, colId, colMin, colMax, separator);
            reader.read();
            exceptionReceived = false;

        } catch (FileNotFoundException e) {
            exceptionReceived = true;
        }
        Assert.assertEquals("FileNotFoundException", exceptionExpected, exceptionReceived);
    }
    private void setup_weatherConfig() {

        filename = "src/main/resources/de/exxcellent/challenge/weather.csv";
        colId  = 1;
        colMin = 3;
        colMax = 2;
        separator = ',';
    }
}
