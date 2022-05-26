package com.genusll.workWithCsv;

import com.genusll.generated.DateOfBirth;
import com.genusll.searching.groups.SearchGroup;
import com.genusll.searching.students.SearchStudent;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.*;

public class CreateCSV {
    public void generatedNewCsv(Integer number) throws IOException {
        String csv = "generated_students.csv";

        char separator = ','; // Field separator character

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        baos.write(0xEF);
        baos.write(0xBB);
        baos.write(0xBF);

        CSVFormat format = CSVFormat.EXCEL.builder().setDelimiter(separator).build();

        try (FileWriter fileWriter = new FileWriter(csv);
             CSVPrinter printer = new CSVPrinter(fileWriter, format)) {

            printer.printRecord(
                    "orgPersonId","lastName","firstName","midName","birthDate","gender"
                    ,"stdGroupName","stdSpecCode","facNameShort","instNameShort","facName","stdSpecName"
                    ,"stdSpecDir"
            );

            List<String> list = new ArrayList<>();

            Integer[] arr = new Integer[number];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i+1;
            }

            SearchStudent searchStudent = new SearchStudent("firstname", "midname", "lastname");
            SearchGroup searchGroup = new SearchGroup("groups");

            DateOfBirth dateOfBirth = new DateOfBirth();

            for (int i = 0; i < number; i++) {
                // Person
                int orgPersonId = arr[i];
                String[] fio = searchStudent.searchingForDataFromStudentMap();
                LocalDate date = dateOfBirth.generatedDateOfBirth();
                // Study
                List<String> group = searchGroup.searchingForDataFromGroup();

                list.add(String.valueOf(orgPersonId));
                list.add(fio[0]);
                list.add(fio[1]);
                list.add(fio[2]);
                list.add(String.valueOf(date));
                list.add(fio[3]);
                list.add(group.get(0));
                list.add(group.get(1));
                list.add(group.get(2));
                list.add(group.get(3));
                list.add(group.get(4));
                list.add(group.get(5));
                if (group.size() == 7){
                    list.add(group.get(6));
                }

                printer.printRecord(list);
                list.clear();
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
