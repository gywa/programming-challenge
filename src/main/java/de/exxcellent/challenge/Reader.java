package de.exxcellent.challenge;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * A Reader class reading weather data from a .csv-file.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public class Reader {

    private String filename;
    private int colId;
    private int colMin;
    private int colMax;
    private char separator;

    public MonthlyWeather monthlyWeather = new MonthlyWeather();

    /**
     * constructor with configuration parameters
     */
    public Reader(String filename, int colId, int colMin, int colMax, char separator) {

        this.filename = filename;
        this.colId = colId;
        this.colMin = colMin;
        this.colMax = colMax;
        this.separator = separator;
    }
    public MonthlyWeather read() throws FileNotFoundException {

        Scanner lineReader = new Scanner(new File(filename));
        boolean firstLine = true;
        DailyWeather dailyWeather;
        MonthlyWeather monthlyWeather = new MonthlyWeather();

        while (lineReader.hasNext()) {

            String line = lineReader.nextLine();
            // System.out.println(line);
            if (!firstLine) {           // skip first line (header)
                dailyWeather = fromCSVline(line);
                monthlyWeather.add(dailyWeather);
            }
            firstLine = false;
        }
        return monthlyWeather;
    }
    private DailyWeather fromCSVline(String line) {

        String[] attributes = line.split(",");
        String strId = attributes[colId-1];        // -1 because we have an index
        String strMin = attributes[colMin-1];
        String strMax = attributes[colMax-1];
        
        return new DailyWeather(Integer.parseInt(strId), Integer.parseInt(strMin),
                                                         Integer.parseInt(strMax));
    }
}
