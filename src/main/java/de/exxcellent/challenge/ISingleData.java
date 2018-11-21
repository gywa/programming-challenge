package de.exxcellent.challenge;

/**
 * Weather data of one day.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public interface ISingleData extends Comparable<Object> {

    /**
     * returns the id of the element
     * @return id of the element
     */
    public String getId();
    /**
     * returns the min value
     * @return min value of the element
     */
    public int getMinValue();
    /**
     * returns the max value
     * @return max value of the element
     */
    public int getMaxValue();
    /**
     * returns the absolute difference between min and max value
     * @return absoulte spread of max and min value
     */
    public int getAbsoluteSpread();
    @Override
    public int compareTo(Object obj);
}
