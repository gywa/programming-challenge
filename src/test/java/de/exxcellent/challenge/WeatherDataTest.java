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
    @Test
    public void weatherDataTest_sortBySpread() {

        int id1 = 2;
        int minValue1 = 55;
        int maxValue1 = 85;
        int id2 = 23;
        int minValue2 = 66;
        int maxValue2 = 68;
        int expectedId = id2;
        int expectedSpread = 2;

        DailyWeather dailyWeather1 = new DailyWeather(id1, minValue1, maxValue1);
        DailyWeather dailyWeather2 = new DailyWeather(id2, minValue2, maxValue2);
        MonthlyWeather monthlyWeather = new MonthlyWeather();
        monthlyWeather.add(dailyWeather1);
        monthlyWeather.add(dailyWeather2);
        monthlyWeather.sortBySpread();

        int receivedId = monthlyWeather.getIdOfMinSpread();
        Assert.assertEquals("getSpread", expectedId, receivedId);
    }
}
