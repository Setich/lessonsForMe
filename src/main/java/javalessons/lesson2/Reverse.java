package javalessons.lesson2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {

    private String inputFromKeyboard() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("error");
        }
        return null;
    }

    private String inputFromFile(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.readLine();
        } catch (IOException e){
            System.out.println("error");
        }
        return null;
    }

    private int[] convert(String input) {
        String[] array = input.split(" ");
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }

    private int[] reverse(int[] intArray) {

        for (int i = 0; i < intArray.length / 2; i++){
            int temp = intArray[i];
            intArray[i] = intArray[intArray.length - 1 - i];
            intArray[intArray.length - 1 - i] = temp;
        }
        return intArray;
    }

    private void printToConsole(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }

    public void startReadingFromKeyboard(){
        printToConsole(reverse(convert(inputFromKeyboard())));
    }

    public void startReadingFromFile(String file){
        printToConsole(reverse(convert(inputFromFile(file))));
    }
}
