package de.exxcellent.challenge;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * A Reader class reading data from a .csv-file.
 * @author Gabriele Wanielik gabriele.wanielik@icloud.com
 */
public interface IReader {

    /**
     * reads the content of the associated file and stores the data in the given type
     */
    public ICollectedData read() throws FileNotFoundException;
    public String getFilename();    // @NonNull ... not working?
}
