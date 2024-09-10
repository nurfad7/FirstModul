package exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CSVReader {
    public void result() {
        String filePath = System.getProperty("user.dir")
                + "\\secondweek\\tuesday\\src"
                + "\\resources\\product_sales_data.csv";
        List<Map<String,?>> table = parseContents(filePath);
    }

    private List<Map<String,?>> parseContents(String filePath) {
        List<Map<String,?>> result = new ArrayList<>();
        HashMap<String, Integer> totalSold = new HashMap<>();
        HashMap<String, Double> itemPrice = new HashMap<>();

        try {
            Scanner scannerFile = new Scanner(new File(filePath));
            boolean headerWasSkipped = false;
            while (scannerFile.hasNextLine()) {
                if (!headerWasSkipped) {
                    headerWasSkipped = true;
                } else {
                    String line = scannerFile.nextLine();
                    String[] row = line.split(",");
                    totalSold.put(row[0], Integer.parseInt(row[1]));
                    itemPrice.put(row[0], Double.parseDouble(row[2]));
                    System.out.println("Content: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Some column not found");
        } catch (NumberFormatException e) {
            System.out.println("file content is not a number");
        }  catch (Exception e) {
            System.out.println("Global Exception");
        } finally {
            System.out.println("file reading done!");
        }
        result.add(totalSold);
        result.add(itemPrice);
        return result;
    }
}
