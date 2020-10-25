package com.example.javaspringbootcustomer.Repository;

import com.example.javaspringbootcustomer.Model.Customer;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
    public static boolean booleanConvert(String v){
        return v.equals("YES");
    }

    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Id", "Title", "Description", "Published" };

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }
        return false;
    }

    public static List<Customer> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Customer> customerList = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Customer customer = new Customer(
                        csvRecord.get("id"),
                        Integer.parseInt(csvRecord.get("age")),
                        booleanConvert(csvRecord.get("sex")),
                        csvRecord.get("region"),
                        Double.parseDouble(csvRecord.get("income")),
                        booleanConvert(csvRecord.get("married")),
                        booleanConvert(csvRecord.get("car")),
                        booleanConvert(csvRecord.get("save_act")),
                        booleanConvert(csvRecord.get("current_act")),
                        booleanConvert(csvRecord.get("mortgage")),
                        booleanConvert(csvRecord.get("pep"))
                );
                customerList.add(customer);
            }
            return customerList;
        } catch (IOException  e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream toCSV(List<Customer> CustomerList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Customer customer : CustomerList) {
                List<String> data = Arrays.asList(
                        customer.getId(),
                        String.valueOf(customer.getAge()),
                        String.valueOf(customer.isSex()),
                        customer.getRegion(),
                        String.valueOf(customer.getIncome()),
                        String.valueOf(customer.isMarried()),
                        String.valueOf(customer.isCar()),
                        String.valueOf(customer.isSaveAct()),
                        String.valueOf(customer.isCurrentAct()),
                        String.valueOf(customer.isMortgage()),
                        String.valueOf(customer.isPep())
                );
                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
