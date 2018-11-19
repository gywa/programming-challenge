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
public class CollectedData<T> implements ICollectedData<T> {    // TODO better name?

    List<T> collected = new ArrayList<T>();

    public void add(<T> t)
    {
        collected.add(t);
    }
    public int getIdOfMinSpread()
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
            System.out.printf("spread of id %d: %d%n", singleData.getId(), singleData.getSpread());
        });
    }
    public void writeSummary()
    {
        System.out.printf("id with smallest spread: %d%n", getIdOfMinSpread());
    }
}
