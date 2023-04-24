package javalessons.lesson2;

import java.io.*;
import java.util.*;

public class Counter {

    private ArrayList<String> inputFile(String file) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ArrayList<String> inputList = new ArrayList<>();
            String line;
            while((line = reader.readLine()) != null) {
                inputList.add(line);
            }
            return inputList;
        } catch (IOException e) {
            System.out.println("Error");
        }
        return null;
    }


    private List<String> convertToLowerCase(List<String> input){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String line : input) {
            String[] str = line.split(" ");
            for ( String s: str) {
                arrayList.add(s.toLowerCase());
            }
        }
        return arrayList;
    }

    private Map<String,Integer> countWords(List<String> lowerCaseList) {
        LinkedHashSet<String> linkedSet = new LinkedHashSet<>(lowerCaseList);
        Map<String, Integer> hashMap = new LinkedHashMap<>();
        int count = 0;
        for (String set : linkedSet) {
            for (String stringList : lowerCaseList) {
                if(set.equals(stringList)){
                    count += 1;
                }
            }
            hashMap.put(set, count);
            count = 0;
        }

        return hashMap;
    }

    private List<String[]> convertCount(Map<String,Integer> oldMap) {
        List<String[]> arrayList = new ArrayList<>();
        Map<String, String> stringMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : oldMap.entrySet()) {
            stringMap.put(entry.getKey(), entry.getValue().toString());
        }

        stringMap.forEach((key, value) -> arrayList.add(new String[]{key, value}));

        return arrayList;
    }

    private void printToFile(List<String[]> convertCount, String file){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String[] stringArray : convertCount) {
                String line = Arrays.toString(stringArray);
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void startReadingToFile(String path, String pathInput){
        printToFile(convertCount(countWords(convertToLowerCase(inputFile(pathInput)))), path);
    }
}
