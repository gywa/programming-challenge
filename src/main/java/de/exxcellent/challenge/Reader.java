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

    // private Vector<String> lineVector;

    public void read(String filename) throws FileNotFoundException {

        Scanner lineReader = new Scanner(new File(filename));

        while (lineReader.hasNext()) {

            String line = lineReader.nextLine();
            System.out.println(line);
            // lineVector.add(line);
        }
        lineReader.close();
    }
}
