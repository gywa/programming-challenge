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
public interface ICollectedData<T> {    // TODO better name?

    public void add(<T> t);
    public int getIdOfMinSpread();
    public void sortBySpread();
    public void verify();
    public void write();
    public void writeSummary();
}
