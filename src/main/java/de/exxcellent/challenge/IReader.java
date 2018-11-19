package de.exxcellent.challenge;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * A Reader class reading weather data from a .csv-file.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public interface IReader<Tcollection, Tsingle> {

    /**
     * constructor with configuration parameters
     * @param filename - name of the file that will be read
     * @param colId - number of the column containing the id
     * @param colMin - number of the column containing the minimum value
     * @param colMax - number of the column containing the maximum value
     * @param separator - char separating the csv columns
     */
    public <Tcollection, Tsingle> IReader<Tcollection, Tsingle>(String filename, int colId, int colMin, int colMax, char separator);
    /**
     * reads the content of the associated file and stores the data in the given type
     */
    public <Tcollection> read<Tsingle>() throws FileNotFoundException;
}
