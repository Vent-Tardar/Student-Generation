package com.genusll.searching.students;

import com.genusll.workWithCsv.ReadCSV;

import java.util.*;

public class SearchingStudent {

    private Map<String, List<String>> name = new HashMap<>();
    private Map<String, List<String>> midname = new HashMap<>();
    private Map<String, List<String>> lastname = new HashMap<>();

    public SearchingStudent(String name, String midname, String lastname) {
        this.name = generatedMap(this.name, Objects.requireNonNull(ReadCSV.readCSV(name)));
        this.midname = generatedMap(this.midname, Objects.requireNonNull(ReadCSV.readCSV(midname)));
        this.lastname = generatedMap(this.lastname, Objects.requireNonNull(ReadCSV.readCSV(lastname)));;
    }

    public String[] searchingForDataFromStudentMap() {
        Random random = new Random();
        String gender = (String) name.keySet().toArray()[random.nextInt(name.size())];

        return new String[]{
                pullsOutARandomString(lastname, gender), pullsOutARandomString(name, gender),
                pullsOutARandomString(midname, gender), gender
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
