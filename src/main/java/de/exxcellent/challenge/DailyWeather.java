package de.exxcellent.challenge;

/**
 * Weather data of one day.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class DailyWeather extends SingleData {

    public DailyWeather(int id, int min, int max) {

        this.name = "Day";
        super(id, min, max);
    }
}
