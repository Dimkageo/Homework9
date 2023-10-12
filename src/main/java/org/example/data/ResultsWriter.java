package org.example.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultsWriter {

    public static void writeResultsToFile(List<Object[]> results, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Object[] result : results) {
                String fullName = (String) result[0];
                String email = (String) result[1];
                String roleName = (String) result[2];
                String numberApartments = String.valueOf((Integer) result[3]);
                String square = String.valueOf((Double) result[4]);
                String address = (String) result[5];
                String houseNumber = (String) result[6];
                String fullNameTenants = (String) result[7];
                Boolean rightOfWay = (Boolean) result[8];

                if (fullName.equals(fullNameTenants) && rightOfWay) {
                    String line = fullName + ", " + email + ", " + roleName + ", №" + numberApartments + ", "
                            + square + "м², " + address + ", " + houseNumber + "\n";

                    writer.write(line);
                    System.out.print(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
