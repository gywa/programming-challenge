package de.exxcellent.challenge;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * A Reader class reading data from a .csv-file.
 * Configuration parameters are provided during construction.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class Reader implements IReader {

    private String filename;
    private String dataName;    // from headerLine[colId]
    private int colId;
    private int colMin;
    private int colMax;
    private char separator;

    /**
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
    public ICollectedData read() throws FileNotFoundException {

        Scanner lineReader = new Scanner(new File(filename));
        boolean firstLine = true;
        ISingleData singleData;
        ICollectedData collectedData = new CollectedData();

        while (lineReader.hasNext()) {

            String line = lineReader.nextLine();
            // System.out.println(line);
            if (firstLine) {
                evalCSVheader(line);
                collectedData.setDataName(dataName);
            }
            else {
                singleData = fromCSVline(line);
                collectedData.add(singleData);
            }
            firstLine = false;
        }
        return collectedData;
    }
    /**
     * extracts a single data from one csv line.
     * @param line - string of a csv line (items separated by the separator char)
     * @returns ISingleData - a single data extracted
     */
    private ISingleData fromCSVline(String line) {

        String[] attributes = line.split(",");
        String strId = attributes[colId-1];        // -1 because we have an index
        String strMin = attributes[colMin-1];
        String strMax = attributes[colMax-1];

        return new DailyWeather(strId, Integer.parseInt(strMin),
                                       Integer.parseInt(strMax));
    }
    /**
     * extracts the data name from the header line of the csv line
     * and stores it in this class.
     * @param line - string of a heading csv line (items separated by the separator char)
     */
    private void evalCSVheader(String line) {

        String[] attributes = line.split(",");
        dataName = attributes[colId-1];    // -1 because we have an index
    }
}
