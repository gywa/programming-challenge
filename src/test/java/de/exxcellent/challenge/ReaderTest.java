package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
* Junit tests for the Reader class.
* @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class ReaderTest {

    private int colId  = 1;
    private int colMin = 3;
    private int colMax = 2;
    private char separator = ',';

    @Before
    public void setUp() throws Exception {
        ; // nothing
    }
    @Test
    public void readerTest_noExcp_FileNotFound() {

        boolean exceptionExpected = false;
        boolean exceptionReceived = false;

        String filename_OK = "src/main/resources/de/exxcellent/challenge/weather.csv";
        try {
            Reader reader = new Reader(filename_OK, colId, colMin, colMax, separator);
            reader.read();
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
            Reader reader = new Reader(filename_NOTOK, colId, colMin, colMax, separator);
            reader.read();

        } catch (FileNotFoundException e) {
            exceptionReceived = true;
            Assert.assertEquals("FileNotFoundException", exceptionExpected, exceptionReceived);
        }
    }
}
