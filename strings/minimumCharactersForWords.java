package strings;

import java.util.ArrayList;
import java.util.HashMap;

public class minimumCharactersForWords {

    public static char[] minimumCharactersForWordsImpl(String[] words) {
        // Write your code here.
        HashMap<Character, Integer> map = new HashMap<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            HashMap<Character, Integer> wordMap = new HashMap<>();

            for (char c : charArray) {
                wordMap.put(c, wordMap.containsKey(c) ? wordMap.get(c) + 1 : 1);

            }
            map = combineMap(map, wordMap);
        }
        return getCharArrayFromMap(map);
    }

    public static HashMap<Character, Integer> combineMap(HashMap<Character, Integer> map, HashMap<Character, Integer> wordMap) {
        for (var entry : wordMap.entrySet()) {
            map.put(entry.getKey(), map.containsKey(entry.getKey()) ?
                    (entry.getValue() > map.get(entry.getKey()) ? entry.getValue() : map.get(entry.getKey())) :
                    entry.getValue());
        }
        return map;
    }

    public static char[] getCharArrayFromMap(HashMap<Character, Integer> map) {
        int size = map.values().stream().mapToInt(Integer::intValue).sum();
        char[] res = new char[size];
        int counter = 0;
        for (var entry : map.entrySet()) {
            int characterCount = entry.getValue();
            while (characterCount > 0) {
                res[counter] = entry.getKey();
                counter++;
                characterCount--;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"this", "that", "did", "deed", "them!", "a"};
        System.out.println(minimumCharactersForWordsImpl(words));
    }
}
