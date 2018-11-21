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

    /**
     * adds new element
     * @param singleData - element to be added
     */
    public void add(ISingleData singleData);
    /**
     * sets the data name
     * @param name - general name of a the elements
     */
    public void setDataName(String name);
    /**
     * returns the data name
     * @param name - general name of a the elements
     */
    public String getDataName();
    /**
     * returns the data name
     * @return id of the element with the smallest absolute spread
     */
    public String getIdOfMinSpread();
    /**
     * sorts the data by the minimum spread
     */
    public void sortBySpread();
    /**
     * verifies the data - could do some aggregation; better name: e.g. aggregate()?
     */
    public void verify();
    /**
     * writes the collection data to the output (for tracing)
     */
    public void write();
    /**
     * writes the collection data to the output (for tracing)
     */
    public void writeSummary();
}
