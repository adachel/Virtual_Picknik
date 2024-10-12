package org.example;

import java.util.*;

public class Word implements IMethodWords {
    private String inputsentence ;

    public Word(String inputSentence) {
        this.inputsentence = inputSentence;
    }

    /**
     * "Очищает" текст от знаков
     * @param sentence - входящий текст
     * @return - коллекция слов
     */
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

    /**
     * Считает, сколько слов в тексте
     * @param arr - коллекция слов
     * @return - размер коллекции
     */
    @Override
    public int CountWords(List<String> arr) {
        return arr.size();
    }

    /**
     * Находит самое длинное слово в коллекции
     * @param arr - коллекция слов
     * @return - самое длинное слово в коллекции
     */
    @Override
    public String LongestWord(List<String> arr) {
        String maxWord = "";
        int lenWord = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).length() > lenWord){
                lenWord = arr.get(i).length();
                maxWord = arr.get(i);
            }
        }
        return maxWord;
    }

    /**
     * частота появления слов в коллекции
     * @param arr - коллекция слов
     * @return - текст, где слово и сколько таких слов в тексте
     */
    @Override
    public String WordFrequency(List<String> arr) {
        String result = "";
        int count = 0;
        HashMap< String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            String a = arr.get(i);
            if (!map.containsKey(arr.get(i))){
                map.put(arr.get(i), count + 1);
            }
            else {
                int value = map.get(arr.get(i));
                map.put(arr.get(i), value + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result = result + entry.getKey() + " - " + entry.getValue() + '\n';

        }
        String er = result;
        return result;
    }

    @Override
    public String toString() {
        return "Count words: " + CountWords(ParseText(inputsentence)) + "\n"
                + "Longest word: " + LongestWord(ParseText(inputsentence)) + "\n"
                + "WordFrequency:" + "\n" + WordFrequency(ParseText(inputsentence));
    }
}
