package de.exxcellent.challenge;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Collected data of the given type.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class CollectedData implements ICollectedData {    // TODO better name?

    List<ISingleData> collected = new ArrayList<ISingleData>();

    public void add(ISingleData singleData)
    {
        collected.add(singleData);
    }
    public String getIdOfMinSpread()
    {
        sortBySpread();
        return collected.get(0).getId();   // TOCHECK: same value for several days?
    }
    public void sortBySpread()
    {
        Collections.sort(collected);
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
        collected.forEach (singleData -> {
            System.out.printf("spread of id %s: %d%n", singleData.getId(), singleData.getSpread());
        });
    }
    public void writeSummary()
    {
        System.out.printf("id with smallest absolute spread: %s%n", getIdOfMinSpread());
    }
}
