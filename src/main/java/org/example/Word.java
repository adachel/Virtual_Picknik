package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Word implements IMethodWords {
    private String inputsentence ;

    public Word(String inputSentence) {
        this.inputsentence = inputSentence;
    }

    @Override
    public List<String> ParseText(String sentence) {
        sentence =  sentence.replace('!', ' ')
                .replace(',', ' ')
                .replace('.', ' ')
                .replace('-', ' ')
                .replaceAll("\\s+", " ")
                .toLowerCase();

        List<String> arr = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).contains("'")){
                String temp = arr.get(i).replace('\'', ' ');
                List<String> tempArr = new ArrayList<>(Arrays.asList(temp.split(" ")));
                String word1 = tempArr.getFirst();
                String word2 = "";
                if (tempArr.getLast().equals("s")){
                    word2 = "i" + tempArr.getLast();
                }
                if (tempArr.getLast().equals("re")){
                    word2 = "a" + tempArr.getLast();
                }
                if (tempArr.getLast().equals("m")){
                    word2 = "a" + tempArr.getLast();
                }
                arr.remove(arr.get(i));
                arr.add(word1);
                arr.add(word2);
            }
        }
        return arr;
    }

    @Override
    public int CountWords(List<String> arr) {
        return arr.size();
    }

    @Override
    public String LongestWord(List<String> text) {
        String maxWord = "";
        int lenWord = 0;
        for (int i = 0; i < text.size(); i++) {
            if (text.get(i).length() > lenWord){
                lenWord = text.get(i).length();
                maxWord = text.get(i);
            }
        }
        return maxWord;
    }

    @Override
    public String WordFrequency(List<String> text) {
        HashMap< String, Integer> map = new HashMap<>();

        return "";
    }


    @Override
    public String toString() {
        return "Count words: " + CountWords(ParseText(inputsentence)) + "\n"
                + "Longest word: " + LongestWord(ParseText(inputsentence));
    }




}
