package com.genusll.workWithCsv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadCSV {
    public static List<String> readCSV(String nameFile) {
        String fileCsv = checkingTheCurrentFolder(new File(System.getProperty("user.dir")), nameFile);
        if (fileCsv != null) {
            try (FileReader reader = new FileReader(fileCsv);
                 CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL)) {
                List<String> record = new ArrayList<>();
                for (CSVRecord csvRecord : csvParser) {
                    for (int i = 0; i < csvRecord.size(); i++) {
                        record.add(csvRecord.get(i));
                    }
                }
                return record;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Please check the folder where the jar file is, it does not contain the CSV files you need");
        }
        return null;
    }

    private static String checkingTheCurrentFolder(File folder, String nameFile){
        String fileCsv = null;
        for (File file: Objects.requireNonNull(folder.listFiles())){
            if (file.getName().contains(nameFile))
                fileCsv = file.getName();
        }
        return fileCsv;
    }
}
