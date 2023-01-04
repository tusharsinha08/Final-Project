import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class CreateSequentialFile {
    private static ObjectOutputStream output;

    public static void openFile() {
        try {
            output = new ObjectOutputStream(
                    Files.newOutputStream(Paths.get("clients.ser")));
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    public static void addRecords(String name, String mobile, String cars, String lic, String time, String level,
            String total) {
        try {
            CarRentalInfo record = new CarRentalInfo(name, mobile, cars, lic,
                    time, level, total);
            output.writeObject(record);
        } catch (NoSuchElementException elementException) {
            System.err.println("Invalid input. Please try again.");
        } catch (IOException ioException) {
            System.err.println("Error writing to file. Terminating.");
        }

    }

    public static void closeFile() {
        try {
            if (output != null)
                output.close();
        } catch (IOException ioException) {
            System.err.println("Error closing file. Terminating.");
        }
    }
}