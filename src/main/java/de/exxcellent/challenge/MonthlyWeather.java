package de.exxcellent.challenge;

/**
 * Weather Data of one month.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class MonthlyWeather {

    // we remember only attributes of interest
    int minValue;           // = MnT (from column 3)
    int maxValue;           // = MxT (from column 2)

    public int getSpread()
    {
        return maxValue - minValue;
    }
}
