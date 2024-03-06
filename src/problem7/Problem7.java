package problem7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class performs the process mentioned in Problem 7.
 * Note: File paths are may be different for other machines
 */
public class Problem7 {

    private static final String INPUT_FILE = ".\\src\\problem7\\employees.csv";
    private static final String MANAGERS_FILE = ".\\src\\problem7\\managers.csv";
    private static final String SINGLE_NAME_EMPLOYEES_FILE = ".\\src\\problem7\\single_name_employees.csv";

    public static void main(String[] args) {

        List<String> managers = new ArrayList<>();
        List<String> singleNameEmployees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
            // Skip the first line (header)
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String fullName = parts[0].trim();
                String role = parts[1].trim();
                String division = parts[2].trim();

                // Employees who are managers in the R&D division.
                if (role.equalsIgnoreCase("Manager") && division.equalsIgnoreCase("R&D")) {
                    managers.add(line);
                }

                //Employees who do not have last names.
                if (fullName.split(" ").length == 1) {
                    singleNameEmployees.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("There was an issue while reading the file. Please check file path and content");
            e.printStackTrace();
        }

        FileReadWriteUtil.writeToFile(MANAGERS_FILE, managers);
        FileReadWriteUtil.writeToFile(SINGLE_NAME_EMPLOYEES_FILE, singleNameEmployees);
    }

}
