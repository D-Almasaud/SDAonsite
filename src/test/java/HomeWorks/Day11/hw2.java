package HomeWorks.Day11;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class hw2 {

    public static void main(String[] args) {
        // Create a File on Desktop
        String userHome = System.getProperty("user.home");
        String desktopPath = Paths.get(userHome, "Desktop").toString();
        String fileName = "TestFile.txt";
        String filePath = Paths.get(desktopPath, fileName).toString();

        // Verify that the file exists
        boolean isExists = Files.exists(Path.of(filePath));

        System.out.println("File Path: " + filePath);
        System.out.println("File Exists: " + isExists);
    }
}