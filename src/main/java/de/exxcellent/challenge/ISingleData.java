package de.exxcellent.challenge;

/**
 * Weather data of one day.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public interface ISingleData extends Comparable<Object> {

    public String getName();
    public String getId();
    public int getSpread();
    public int getAbsoluteSpread();
    @Override
    public int compareTo(Object obj);
}
