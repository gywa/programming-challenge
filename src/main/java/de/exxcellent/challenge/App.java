package de.exxcellent.challenge;

import java.io.*;
import java.io.FileNotFoundException;
/**
 * Java application that reads football data results from a .csv-file
 * and outputs the day with the smallest temperature spread.
 * The name of the .csv-file is "football.csv". It is taken from the resources folder.
 *
 *  @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public final class App {

    public static final String filename = "src/main/resources/de/exxcellent/challenge/football.csv";
    public static final int colId  = 1;
    public static final int colMin = 7;
    public static final int colMax = 6;
    public static final char separator = ',';

    public Reader reader = new Reader(filename, colId, colMin, colMax, separator);

    public static void main(String... args) {

        // Your preparation code …
        try {
            App app = new App();

            ICollectedData collectedData = app.reader.read();
            collectedData.verify();
            collectedData.write();
            collectedData.writeSummary();

        } catch (IOException e) {
            System.out.printf("... error: IOException %e!%n", e);
        }
    }
}
