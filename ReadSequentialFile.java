import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadSequentialFile {
    private static ObjectInputStream input;
    private static ArrayList<CarRentalInfo> list;

    public static void main(String[] args) {
        openFile();
        readRecords();
        closeFile();
    }

    public static void openFile() {
        try // open file

        {
            input = new ObjectInputStream(
                    Files.newInputStream(Paths.get("clients.ser")));
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    public static ArrayList<CarRentalInfo> readRecords() {
        openFile();
        list = new ArrayList<>();

        try {
            while (true) // loop until there is an EOFException
            {
                CarRentalInfo record = (CarRentalInfo) input.readObject();
                list.add(record);
            }
        } catch (EOFException endOfFileException) {
            System.out.printf("%nNo more records%n");
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Invalid object type. Terminating.");
        } catch (IOException ioException) {
            System.err.println("Error reading from file. Terminating.");
        }

        closeFile();

        return list;
    }

    public static void closeFile() {
        try {
            if (input != null)
                input.close();
        } catch (IOException ioException) {
            System.err.println("Error closing file. Terminating.");
            System.exit(1);
        }
    }
}