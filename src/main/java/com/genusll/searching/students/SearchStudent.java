package com.genusll.searching.students;

import com.genusll.workWithCsv.ReadCSV;

import java.util.*;

public class SearchStudent {

    private Map<String, List<String>> nameMap = new HashMap<>();
    private Map<String, List<String>> midnameMap = new HashMap<>();
    private Map<String, List<String>> lastnameMap = new HashMap<>();

    public SearchStudent(String name, String midname, String lastname) {
        this.nameMap = generatedMap(this.nameMap, ReadCSV.readCSV(name));
        this.midnameMap = generatedMap(this.midnameMap, ReadCSV.readCSV(midname));
        this.lastnameMap = generatedMap(this.lastnameMap, ReadCSV.readCSV(lastname));
    }

    public String[] searchingForDataFromStudentMap() {
        Random random = new Random();
        String gender = (String) nameMap.keySet().toArray()[random.nextInt(nameMap.size())];

        return new String[]{
                pullsOutARandomString(lastnameMap, gender), pullsOutARandomString(nameMap, gender),
                pullsOutARandomString(midnameMap, gender), gender
        };
    }

    private Map<String, List<String>> generatedMap(Map<String, List<String>> map, List<String> list){
        List<String> male = new ArrayList<>();
        List<String> female = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("М")) {
                male.add(list.get(i-1));
            } else if (list.get(i).equals("Ж"))
                female.add(list.get(i-1));
        }
        map.put("М", male);
        map.put("Ж", female);
        return map;
    }

    private String pullsOutARandomString(Map<String, List<String>> map, String gender){
        List<String> list = map.get(gender);
        return list.get(new Random().nextInt(list.size()));
    }
}
