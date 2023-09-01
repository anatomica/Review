import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        findAllRecords();
    }

    private static void findAllRecords() {
        List<String> values = new ArrayList<String>();
        values = getAllRecords();
        String concatenation = "";
        if (!values.isEmpty()) {
            for (int i = 0; i <= values.size(); i++) {
                if (values.get(i) == concatenation) {
                    System.out.println(values.get(i));
                }
                concatenation += values.get(i);
            }
            System.out.println(concatenation);
        }
        System.out.println(values);
    }

    private static List<String> getAllRecords() {
        List<String> allRecords = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/file.txt"), 10);
            while (reader.readLine() != null) {
                String line = reader.readLine();
                allRecords.add(line);
            }
            return allRecords;
        } catch (Exception e) {
            System.out.println("Error reading: " + e.getMessage());
            return null;
        }
    }
}