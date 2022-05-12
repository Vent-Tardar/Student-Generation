package com.genusll.searching.students;

import com.genusll.workWithCsv.ReadCSV;

import java.util.*;

public class SearchingStudent {

    private Map<String, List<String>> name = new HashMap<>();
    private Map<String, List<String>> midname = new HashMap<>();
    private Map<String, List<String>> lastname = new HashMap<>();

    public String[] searchingForDataFromStudentMap() {
        if (name.size() == 0 && midname.size() == 0 && lastname.size() == 0) {
            name = generatedMap(name, ReadCSV.readCSV("firstname"));
            midname = generatedMap(midname, ReadCSV.readCSV("midname"));
            lastname = generatedMap(lastname, ReadCSV.readCSV("lastname"));
        }

        Random random = new Random();

        String gender = (String) name.keySet().toArray()[random.nextInt(name.size())];
        String genderMN = "";
        String genderLN = "";

        while (!gender.equals(genderMN)) {
            genderMN = (String) midname.keySet().toArray()[random.nextInt(midname.size())];
        }

        while (!gender.equals(genderLN)) {
            genderLN = (String) lastname.keySet().toArray()[random.nextInt(lastname.size())];
        }

        return new String[]{
                pullsOutARandomString(lastname, gender), pullsOutARandomString(name, gender),
                pullsOutARandomString(midname, gender), gender
        };
    }

    private Map<String, List<String>> generatedMap(Map<String, List<String>> map, List<String> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("М") || list.get(i).equals("Ж")) {
                if (!map.containsKey(list.get(i))) {
                    map.put(list.get(i), new ArrayList<>());
                }
                map.get(list.get(i)).add(list.get(i-1));
            }
        }
        return map;
    }

    private String pullsOutARandomString(Map<String, List<String>> map, String gender){
        List<String> list = map.get(gender);
        return list.get(1 + new Random().nextInt(list.size() - 1));
    }
}
