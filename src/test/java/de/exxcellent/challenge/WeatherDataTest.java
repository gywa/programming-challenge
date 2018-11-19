package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit tests for the weatherData class.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class WeatherDataTest {

    @Before
    public void setUp() throws Exception {
        ; // nothing
    }

    @Test
    public void weatherDataTest_getSpread() {

        int minValue = 22;
        int maxValue = 55;
        int expectedSpread = maxValue - minValue;

        DailyWeather dailyWeather = new DailyWeather(2, minValue, maxValue);
        int receivedSpread = dailyWeather.getSpread();
        Assert.assertEquals("getSpread", expectedSpread, receivedSpread);
    }
}
