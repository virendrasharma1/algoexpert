package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {

    public static List<List<String>> groupAnagramsImpl(List<String> words) {
        // Write your code here.
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            String sorted = sortedString(word);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }
        return map.values().stream().toList();
    }

    public static String sortedString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp");
        System.out.println(groupAnagramsImpl(words));
    }
}
