package de.exxcellent.challenge;

/**
 * Weather data of one day.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class ISingleData implements Comparable<Object> {

    public ISingleData(int id, int min, int max);
    public int getId();
    public int getSpread();
    @Override
    public int compareTo(Object obj);
}
