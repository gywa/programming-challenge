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
public interface ICollectedData {    // TODO better name?

    public void add(ISingleData singleData);
    public String getIdOfMinSpread();
    public void sortBySpread();
    public void verify();
    public void write();
    public void writeSummary();
}
