package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static String GetTextFromFile(String fileName){
        String line = "empty";
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/input.txt");
            line = Files.readString(Path.of(pathFile));
        }
        catch (Exception e) {System.out.println(e.getMessage());;}
        return line;
    }
    public static void main(String[] args) throws IOException {
        String fileName = "input.txt";
        String text = GetTextFromFile(fileName);

        Word result = new Word(text);
        System.out.println(result.toString());
    }
}