package de.exxcellent.challenge;

/**
 * Weather data of one day.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class SingleData implements ISingleData {

    // we remember only attributes of interest
    String name;
    String id;              // = Name (from column 1)
    int minValue;           // = MnT (from column 3)
    int maxValue;           // = MxT (from column 2)

    public SingleData(String name, String id, int min, int max) {

        this.name = name;
        this.id = id;
        this.minValue = min;
        this.maxValue = max;
    }
    public String getName()
    {
        return name;
    }
    public String getId()
    {
        return id;
    }
    public int getSpread()
    {
        return maxValue - minValue;
    }
    public int getAbsoluteSpread()
    {
        return Math.abs(getSpread());
    }
    @Override
    public int compareTo(Object obj) {
        ISingleData singleData = (ISingleData) obj;
        return this.getAbsoluteSpread() - singleData.getAbsoluteSpread();
    }
}
