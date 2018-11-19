package de.exxcellent.challenge;

/**
 * Weather data of one day.
 *
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class SingleData implements ISingleData {

    // we remember only attributes of interest
    String name = "?";
    int id;                 // = Day (from column 1)
    int minValue;           // = MnT (from column 3)
    int maxValue;           // = MxT (from column 2)

    public SingleData(int id, int min, int max) {

        this.id = id;
        this.minValue = min;
        this.maxValue = max;
    }
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    public int getSpread()
    {
        return maxValue - minValue;
    }
    @Override
    public int compareTo(Object obj) {
        SingleData singleData = (SingleData) obj;
        return this.getSpread() - singleData.getSpread();
    }
}
