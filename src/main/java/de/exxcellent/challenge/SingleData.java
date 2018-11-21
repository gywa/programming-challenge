package de.exxcellent.challenge;

/**
 * Weather data of one day.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class SingleData implements ISingleData {

    // we remember only attributes of interest
    String id;              // = Name (from column 1)
    int minValue;           // = MnT (from column 3)
    int maxValue;           // = MxT (from column 2)

    public SingleData(String id, int min, int max) {

        this.id = id;
        this.minValue = min;
        this.maxValue = max;
    }
    public String getId()
    {
        return id;
    }
    public int getMinValue()
    {
        return minValue;
    }
    public int getMaxValue()
    {
        return maxValue;
    }
    /*public int getSpread()
    {
        return maxValue - minValue;
    }*/
    public int getAbsoluteSpread()
    {
        return Math.abs(maxValue - minValue);
    }
    @Override
    public int compareTo(Object obj) {
        ISingleData singleData = (ISingleData) obj;
        return this.getAbsoluteSpread() - singleData.getAbsoluteSpread();
    }
}
