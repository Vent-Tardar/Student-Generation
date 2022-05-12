package com.genusll;

import com.genusll.workWithCsv.CreateCSV;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = args[0];
        if (Pattern.matches("\\d+", input)) {
            int num = Integer.parseInt(input);
            CreateCSV csv = new CreateCSV();
            System.out.println("File generation has started");
            System.out.println("Please wait, the file is being generated");
            csv.generatedNewCsv(num);
            System.out.println("File generation is complete");
        } else {
            if (input.isEmpty()) {
                System.out.println("Unfortunately, such a number of rows cannot be generated");
            } else {
                System.out.println("Wrong! Please enter correct number");
            }
        }
    }
}