package com.genusll.searching.groups;

import com.genusll.workWithCsv.ReadCSV;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SearchingGroup {
    private static List<String> listOfGroup = new ArrayList<>();
    public List<String> searchingForDataFromGroup() throws URISyntaxException {
        if (listOfGroup.size() == 0){
            listOfGroup = ReadCSV.readCSV("groups");
        }
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < listOfGroup.size()-7; i=i+7) {
            temp.add(
                    listOfGroup.get(i)+", "+listOfGroup.get(i+1)
                    +", "+listOfGroup.get(i+2)+", "+listOfGroup.get(i+3)
                    +", "+listOfGroup.get(i+4)+", "+listOfGroup.get(i+5)
                    +", "+listOfGroup.get(i+6)
            );
        }

        Random random = new Random();
        String[] tmp = temp.get(1 + random.nextInt(temp.size() - 1)).split(",(?!\\s\\p{Ll}) ");

        List<String> list = Arrays.asList(tmp);
        List<String> record = new ArrayList<>(list);

        String[] temp1;
        if (record.size() < 5){
            temp1 = record.get(record.size()-1).split(", ");
            record.set(record.size()-1, temp1[0]);
            record.add(temp1[1]);
        }

        if (record.size() < 6){
            temp1 = record.get(record.size()-1).split(", ");
            record.set(record.size()-1, temp1[0]);
            record.add(temp1[1]);
        }

        return record;
    }
}
