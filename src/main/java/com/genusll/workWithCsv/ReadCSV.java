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
        /*The beginning of the fragment to comment out if you need to run the program through the IDE*/
        /*String path = ReadCSV.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String pathTemp = path.substring(0, path.lastIndexOf("/") + 1);
        String decodedPath = URLDecoder.decode(pathTemp, StandardCharsets.UTF_8);
        String ext = ".csv";
        File[] listFiles = findFiles(decodedPath, ext);
        for (File fileName: listFiles) {
            if (fileName.getName().contains(nameFile)){
                try (FileReader reader = new FileReader(fileName.getName());
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
            }
        }
        return null;*/
        /*The end of the fragment to comment out if you need to run the program through the IDE*/

        /*The beginning of the fragment to uncomment if you need to run the program through the IDE*/
        try (Reader reader = new BufferedReader(new InputStreamReader
                (Objects.requireNonNull(ReadCSV.class.getResourceAsStream("/sample_"+nameFile + ".csv"))));
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
        /*The end of the fragment to uncomment if you need to run the program through the IDE*/
    }

    private static File[] findFiles(String dir, String ext) {
        File file = new File(dir);
        PrintStream ps = new PrintStream(System.out, false, StandardCharsets.UTF_8);
        if(!file.exists()) ps.println("The folder "+ dir + "does not exist");
        File[] listFiles = file.listFiles(new FileNameFilter(ext));
        if(listFiles.length == 0){
            ps.println(dir + " does not contain files with the extension " + ext);
        }else return listFiles;
        return null;
    }
}
