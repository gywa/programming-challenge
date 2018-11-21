package de.exxcellent.challenge;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Weather Data of one month - unused!
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class MonthlyWeather extends CollectedData {

    public void write()
    {
        collected.forEach (singleData -> {
            System.out.printf("Spread of %d. %s: %d%n", getDataName(), singleData.getId(),
                                singleData.getAbsoluteSpread());
        });
    }
    public void writeSummary()
    {
        System.out.printf("%s with smallest spread: %d%n", getDataName(), getIdOfMinSpread());
    }
}
