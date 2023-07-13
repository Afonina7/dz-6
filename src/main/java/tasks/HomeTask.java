package tasks;

import java.util.*;

public class HomeTask {

    public static void main(String[] args) {
        printEvenChars(new String[]{"мама", "лалапапа", "тато", "їж їжак желе", "івавіавіав", "папа"});
    }

    public static void printEvenChars(String[] words) {
        List<String> evenWords = new ArrayList<>();
        int counter = 0;
        for (String word : words) {
            Map<Character, Integer> charCount = countCharacters(word);
            if (isEvenCountOfChars(charCount)) {
                evenWords.add(word);
                if (++counter == 2)
                    break;
            }
        }
        Set<Character> uniqueChars = getUniqueChars(evenWords);
        System.out.println(uniqueChars);
    }

    private static Map<Character, Integer> countCharacters(String word) {
        char[] chars = word.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();

        for (char ch : chars) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        return charCount;
    }

    private static Set<Character> getUniqueChars(List<String> list) {
        Set<Character> uniqueChars = new HashSet<>();
        for (String word : list) {
            char[] chars = word.toCharArray();
            for (char ch : chars)
                uniqueChars.add(ch);
        }
        return uniqueChars;
    }

    private static boolean isEvenCountOfChars(Map<Character, Integer> charCount) {
        boolean isEven = false;
        for (Character ch : charCount.keySet()) {
            isEven = charCount.get(ch) % 2 == 0;
            if (!isEven) break;
        }
        return isEven;
    }
}