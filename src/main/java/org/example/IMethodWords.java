package org.example;

import java.util.List;

public interface IMethodWords {
    int CountWords(List<String> text);
    List<String> ParseText(String sentence);
    String LongestWord(List<String> text);
    String WordFrequency(List<String> text);
}
