package exercise;

import exceptions.FormatColumnException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CSVReader {
    public void result() throws FileNotFoundException {
        String filePath = System.getProperty("user.dir")
                + "\\secondweek\\tuesday\\src"
                + "\\resources\\product_sales_data.csv";
        //List<Map<String,?>> table = parseContents(filePath);
        processTheFile(filePath);
    }

    private void processTheFile(String filePath) throws FileNotFoundException {
        String productMostBought = "", productLeastBought = "";
        int highestSold = Integer.MIN_VALUE,
                lowestSold = Integer.MAX_VALUE,
                totalProductSold = 0;
        double totalSales = 0.0;
        Scanner scannerFile = new Scanner(new File(filePath));
        boolean isHeader = false;
        while (scannerFile.hasNextLine()) {
            String line = scannerFile.nextLine();
            String[] row = line.split(",");
            if (row.length == 0) {
                throw new FormatColumnException();
            } else {
                try {
                    int totalSold = Integer.parseInt(row[1]);
                    double itemPrice = Double.parseDouble(row[2]);
                    totalProductSold += totalSold;
                    totalSales += (totalSold * itemPrice);
                    if (highestSold < totalSold) {
                        highestSold = totalSold;
                        productMostBought = row[0];
                    }
                    if (lowestSold > totalSold) {
                        lowestSold = totalSold;
                        productLeastBought = row[0];
                    }
                } catch (NumberFormatException e) {
                    if(!isHeader) {
                        isHeader = true;
                    } else {
                        System.out.println("Some data have invalid format. It must be a number.");
                    }
                    continue;
                }
            }
        }
        System.out.println("Total Sales: " + String.format("%.2f", totalSales));
        System.out.println("Total Product Sold: " + totalProductSold);
        System.out.println("Most Bought Product:  " + productMostBought);
        System.out.println("Least Bought Product: " + productLeastBought);
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
