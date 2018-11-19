package de.exxcellent.challenge;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Weather Data of one month.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class MonthlyWeather {

    // Set<DailyWeather> dailyWeathers = new HashSet<DailyWeather>(); => unique
    List<DailyWeather> dailyWeathers=new ArrayList<DailyWeather>();

        public void add(DailyWeather dailyWeather)
    {
        dailyWeathers.add(dailyWeather);
    }
    public int getIdOfMinSpread()
    {
        sortBySpread();
        return dailyWeathers.get(0).getId();   // TOCHECK: same value for several days?
    }
    public void sortBySpread()
    {
        Collections.sort(dailyWeathers);
        /* not OK: Collections.sort(dailyWeathers, (a, b) -> {
                return a.getSpread().compareTo(b.getSpread());
        });*/
    }
    public void verify()
    {
        // check business logic etc. e.g. verify the dates?
    }
    public void write()
    {
        dailyWeathers.forEach (dailyWeather -> {
            System.out.printf("spread on %d. day: %d%n", dailyWeather.getId(),dailyWeather.getSpread());
        });
    }
    public void writeSummary()
    {
        System.out.printf("Day with smallest temperature spread: %d%n", getIdOfMinSpread());
    }
}
