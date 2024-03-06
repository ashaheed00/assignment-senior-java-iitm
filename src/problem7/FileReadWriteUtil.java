package problem7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * This class is having utility methods for common file read write operations
 */
public class FileReadWriteUtil {

    /**
     * Writes list of lines to the given file.
     * Handles thrown IOException with proper user message.
     *
     * @param fileName file name with proper path
     * @param lines    content of the file
     */
    public static void writeToFile(String fileName, List<String> lines) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("There was an issue while writing the file. Please check file path and content");
            e.printStackTrace();
        }
    }
}
