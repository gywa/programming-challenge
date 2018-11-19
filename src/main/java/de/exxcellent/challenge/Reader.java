package de.exxcellent.challenge;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * A Reader class reading data from a .csv-file.
 * In the first approach the line read is printed out again after reading.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class Reader {

    private String filename;
    private int colId;
    private int colMin;
    private int colMax;
    private char separator;

    public MonthlyWeather monthlyWeather = new MonthlyWeather();

    public Reader(String filename, int colId, int colMin, int colMax, char separator) {

        this.filename = filename;
        this.colId = colId;
        this.colMin = colMin;
        this.colMax = colMax;
        this.separator = separator;
    }
    public void read() throws FileNotFoundException {

        Scanner lineReader = new Scanner(new File(filename));
        boolean firstLine = true;
        DailyWeather dailyWeather;

        while (lineReader.hasNext()) {

            String line = lineReader.nextLine();
            // System.out.println(line);
            if (!firstLine) {           // skip first line (header)
                dailyWeather = fromCSVline(line);
                System.out.printf("spread on %d. day: %d%n", dailyWeather.getId(),
                    dailyWeather.getSpread());
                // monthlyWeather.add(dailyWeather);
            }
            firstLine = false;
        }
    }
    private DailyWeather fromCSVline(String line) {
// throws NumberFormatException
        String[] attributes = line.split(",");
        String strId = attributes[colId-1];        // -1 because we have an index
        String strMin = attributes[colMin-1];
        String strMax = attributes[colMax-1];
        // System.out.printf("weather on %s. day: %s - %s%n", strId, strMin, strMax);
        // System.out.printf("weather on %d. day: %d - %d%n", Integer.parseInt(strId), Integer.parseInt(strMin), Integer.parseInt(strMax));
        return new DailyWeather(Integer.parseInt(strId), Integer.parseInt(strMin),
                                                         Integer.parseInt(strMax));
    }
}
