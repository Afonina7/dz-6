package tasks;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HomeTask {

    public static void main(String[] args) {
        String[] words ={"мама", "лалапапа", "тато", "їж їжак желе", "баба"};
        Set<Character> uniqueChars = findUniqueCharacters(words);
        System.out.println(uniqueChars);
    }

    public static Set<Character> findUniqueCharacters(String[] words) {
        List<String> wordList = Arrays.asList(words);
        List<String> filteredWords = wordList.stream()
                .filter(word -> countEvenOccurrences(word) >= 2)
                .limit(2)
                .collect(Collectors.toList());

        Set<Character> uniqueChars = filteredWords.stream()
                .flatMap(word -> word.chars().mapToObj(ch -> (char) ch))
                .collect(Collectors.toSet());

        return uniqueChars;
    }

    public static long countEvenOccurrences(String word) {
        Map<Character, Long> charCounts = word.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return charCounts.size();
    }
}