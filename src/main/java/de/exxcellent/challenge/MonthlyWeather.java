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
public class MonthlyWeather extends CollectedData {

    public void write()
    {
        collected.forEach (singleData -> {
            System.out.printf("spread on %d. %s: %d%n", singleData.getId(),
                                singleData.getName(),singleData.getSpread());
        });
    }
    public void writeSummary()
    {
        System.out.printf("Day with smallest temperature spread: %d%n", getIdOfMinSpread());
    }
}
