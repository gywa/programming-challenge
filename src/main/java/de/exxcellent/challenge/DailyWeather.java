package de.exxcellent.challenge;

/**
 * Weather data of one day.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class DailyWeather extends SingleData {

    public DailyWeather(String id, int min, int max) {

        super("Day", id, min, max);
    }
}
