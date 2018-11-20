package de.exxcellent.challenge;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * A Reader class reading weather data from a .csv-file.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class Reader implements IReader {

    private String filename;
    private int colId;
    private int colMin;
    private int colMax;
    private char separator;

    /*
     * constructor with configuration parameters
     * @param filename - name of the file that will be read
     * @param colId - number of the column containing the id
     * @param colMin - number of the column containing the minimum value
     * @param colMax - number of the column containing the maximum value
     * @param separator - char separating the csv columns
     */
    public Reader(String filename, int colId, int colMin, int colMax, char separator) {

        this.filename = filename;
        this.colId = colId;
        this.colMin = colMin;
        this.colMax = colMax;
        this.separator = separator;
    }
    public String getFilename() {
        return filename;
    }
    public ICollectedData read() throws FileNotFoundException {

        Scanner lineReader = new Scanner(new File(getFilename()));
        boolean firstLine = true;
        ISingleData singleData;
        ICollectedData collectedData = new CollectedData();

        while (lineReader.hasNext()) {

            String line = lineReader.nextLine();
            // System.out.println(line);
            if (!firstLine) {           // skip first line (header)
                singleData = fromCSVline(line);
                collectedData.add(singleData);
            }
            firstLine = false;
        }
        return collectedData;
    }
    private ISingleData fromCSVline(String line) {

        String[] attributes = line.split(",");
        String strId = attributes[colId-1];        // -1 because we have an index
        String strMin = attributes[colMin-1];
        String strMax = attributes[colMax-1];

        return new DailyWeather(strId, Integer.parseInt(strMin),
                                       Integer.parseInt(strMax));
    }
}
