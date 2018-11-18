package de.exxcellent.challenge;

/**
 * Weather Data that will be required for the App.
 * Yet not used.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class WeatherData {

    // we remember only attributes of interest
    int minValue;           // = MnT (from column 3)
    int maxValue;           // = MxT (from column 2)
    int spread;

    // getter-Methode für die Matrikelnummer
    public int getSpread()
    {
        return maxValue - minValue;
    }
}
