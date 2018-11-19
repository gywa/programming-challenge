package de.exxcellent.challenge;

/**
 * Weather Data of one day.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class DailyWeather {

    // we remember only attributes of interest
    int id;                 // = Day (from column 1)
    int minValue;           // = MnT (from column 3)
    int maxValue;           // = MxT (from column 2)

    public DailyWeather(int id, int min, int max) {

        this.id = id;
        this.minValue = min;
        this.maxValue = max;
    }
    public int getId()
    {
        return id;
    }
    public int getSpread()
    {
        return maxValue - minValue;
    }
}
