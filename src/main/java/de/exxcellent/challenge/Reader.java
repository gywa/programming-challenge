package de.exxcellent.challenge;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * A Reader class reading weather data from a .csv-file.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class Reader<Tcollection, Tsingle> implements IReader<Tcollection, Tsingle> {

    private String filename;
    private int colId;
    private int colMin;
    private int colMax;
    private char separator;

    private <Tcollection> CollectedData = new CollectedData<Tsingle>();

    /**
     * constructor with configuration parameters
     */
    public Reader<Tcollection, Tsingle>(String filename, int colId, int colMin, int colMax, char separator) {

        this.filename = filename;
        this.colId = colId;
        this.colMin = colMin;
        this.colMax = colMax;
        this.separator = separator;
    }
    public <Tcollection> read() throws FileNotFoundException {

        Scanner lineReader = new Scanner(new File(filename));
        boolean firstLine = true;
        <Tsingle> singleData;
        Tcollection collectedData = new CollectedData<Tsingle>();

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
    private <Tsingle> fromCSVline(String line) {

        String[] attributes = line.split(",");
        String strId = attributes[colId-1];        // -1 because we have an index
        String strMin = attributes[colMin-1];
        String strMax = attributes[colMax-1];

        return new SingleData<Tsingle>(Integer.parseInt(strId), Integer.parseInt(strMin),
                                                         Integer.parseInt(strMax));
    }
}
