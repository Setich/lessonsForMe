package javalessons.lesson2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Revers2 {
    private List<String> inputFromKeyboard() {
        List<String> inputList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputList.add(line);
            }
        return inputList;
        } catch (IOException e) {
            System.out.println("Error");
        }
        return null;
    }

    private List<int[]> convert(List<String> input) {
        List<int[]> arrayList = new ArrayList<>();
        for (String str : input) {
            String[] strArray = str.split(" ");
            int[] intArray = new int[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }
            arrayList.add(intArray);
        }
        return arrayList;
    }

    private List<int[]> reverse(List<int[]> inputList) {
        Collections.reverse(inputList);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            int[] arrayIndexNumber = inputList.get(i);
            for (int j = 0; j < arrayIndexNumber.length / 2; j++) {
                int temp = arrayIndexNumber[j];
                arrayIndexNumber[j] = arrayIndexNumber[arrayIndexNumber.length - 1 - j];
                arrayIndexNumber[arrayIndexNumber.length - 1 - j] = temp;
            }
            result.add(arrayIndexNumber);
        }
        return result;
    }

    private void printToFile(List<int[]> listArray, String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int[] intArray : listArray) {
                String line = Arrays.toString(intArray);
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void startReadingFromFile(String path) {
        printToFile(reverse(convert(inputFromKeyboard())), path);
    }


}
