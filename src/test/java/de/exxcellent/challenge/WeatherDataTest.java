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

        DailyWeather dailyWeather = new DailyWeather("2", minValue, maxValue);
        int receivedSpread = dailyWeather.getSpread();
        Assert.assertEquals("getSpread", expectedSpread, receivedSpread);
    }
    @Test
    public void weatherDataTest_sortBySpread() {

        String id1 = "2";
        int minValue1 = 55;
        int maxValue1 = 85;
        String id2 = "23";
        int minValue2 = 66;
        int maxValue2 = 68;
        String expectedId = id2;
        int expectedSpread = 2;

        DailyWeather dailyWeather1 = new DailyWeather(id1, minValue1, maxValue1);
        DailyWeather dailyWeather2 = new DailyWeather(id2, minValue2, maxValue2);
        MonthlyWeather monthlyWeather = new MonthlyWeather();
        monthlyWeather.add(dailyWeather1);
        monthlyWeather.add(dailyWeather2);
        monthlyWeather.sortBySpread();

        String receivedId = monthlyWeather.getIdOfMinSpread();
        Assert.assertEquals("id of min spread -", expectedId, receivedId);
    }
    @Test
    public void weatherDataTest_sortBySpread_Absolute() {

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

        DailyWeather dailyWeather1 = new DailyWeather(id1, minValue1, maxValue1);
        DailyWeather dailyWeather2 = new DailyWeather(id2, minValue2, maxValue2);
        DailyWeather dailyWeather3 = new DailyWeather(id3, minValue3, maxValue3);
        MonthlyWeather monthlyWeather = new MonthlyWeather();
        monthlyWeather.add(dailyWeather1);
        monthlyWeather.add(dailyWeather2);
        monthlyWeather.add(dailyWeather3);
        monthlyWeather.sortBySpread();

        String receivedId = monthlyWeather.getIdOfMinSpread();
        Assert.assertEquals("id of min spread -", expectedId, receivedId);
    }
}
