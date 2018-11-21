package de.exxcellent.challenge;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Collected data of the type ISingleData.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class CollectedData implements ICollectedData {    // TODO better name?

    List<ISingleData> collected = new ArrayList<ISingleData>();
    String dataName;

    public void add(ISingleData singleData)
    {
        collected.add(singleData);
    }
    public String getDataName()
    {
        return dataName;
    }
    public void setDataName(String name)
    {
        dataName = name;
    }
    public String getIdOfMinSpread()
    {
        sortBySpread();
        return collected.get(0).getId();   // TOCHECK: same value for several days?
    }
    public void sortBySpread()  // TODO use correct compareTo method (currently used: compareTo from SingleData!)
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
            System.out.printf("spread of %s %s: %d (%d-%d)%n", getDataName(), singleData.getId(), singleData.getAbsoluteSpread(),
                                singleData.getMinValue(), singleData.getMaxValue());
        });
    }
    public void writeSummary()
    {
        System.out.printf("%s with smallest absolute spread: %s%n", getDataName(), getIdOfMinSpread());
    }
}
