package com.genusll.searching.groups;

import com.genusll.workWithCsv.ReadCSV;

import java.net.URISyntaxException;
import java.util.*;

public class SearchGroup {

    private Map<Integer, List<String>> map = new HashMap<>();

    public SearchGroup(String groups) {
        this.map = generatedMap(this.map, Objects.requireNonNull(ReadCSV.readCSV(groups)));
    }

    public List<String> searchingForDataFromGroup() throws URISyntaxException {
        return map.get(1 + (int) (Math.random()* map.size()));
    }

    private Map<Integer, List<String>> generatedMap(Map<Integer, List<String>> map, List<String> list){
        List<String> temp = new ArrayList<>();
        int number = 1;
        for (String s: list) {
            if (temp.size() == 6){
                map.put(number, new ArrayList<>(temp));
                temp.clear();
                number++;
            } else {
                temp.add(s);
            }
        }
        return map;
    }
}
