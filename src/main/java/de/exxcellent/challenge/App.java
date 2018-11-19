package de.exxcellent.challenge;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * Java application that reads the weaterh data from a .csv-file
 * and outputs the day with the smallest temperature spread.
 * The name of the .csv-file is "weather.csv". It is taken from the resources folder.
 *
 *  @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public final class App {

    public static final String filename = "src/main/resources/de/exxcellent/challenge/weather.csv";
    public static final int colId  = 1;
    public static final int colMin = 3;
    public static final int colMax = 2;
    public static final char separator = ',';

    public Reader reader = new Reader(filename, colId, colMin, colMax, separator);
    public MonthlyWeather monthlyWeather;
    // private Vector<String> lineVector;

    public static void main(String... args) {

        // Your preparation code …
        try {
            App app = new App();

            System.out.printf("... starting reading %n");
            app.reader.read(); // monthlyWeather = ...

        // String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        // String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        // System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        // System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
        // for(int i=0; i < lineVector.size(); i++) {
        //     System.out.println("entry " + i + ": " + ((WeatherData)vec.elementAt(i)).getX());
        // }
            System.out.printf("... finished%n");

        } catch (IOException e) {
            System.out.printf("... error: IOException %e!%n", e);
        }
    }
}
