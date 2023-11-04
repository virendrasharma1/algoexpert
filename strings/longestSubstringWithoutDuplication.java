package strings;

import java.util.HashMap;
import java.util.Map;

public class longestSubstringWithoutDuplication {

    public static String longestSubstringWithoutDuplicationImpl(String str) {
        Map<Character, Integer> map = new HashMap<>();
        String longestSubstring = "";
        int start = 0;
        String currentSubstring = "";

        while (start < str.length()) {

            if (map.containsKey(str.charAt(start))) {
                start = map.get(str.charAt(start));
                if (currentSubstring.length() > longestSubstring.length()) {
                    longestSubstring = currentSubstring;
                }
                currentSubstring = "";
                map.clear();
            } else {
                currentSubstring = currentSubstring + str.charAt(start);
                map.put(str.charAt(start), start);
            }
            start++;
        }
        if (currentSubstring.length() > longestSubstring.length()) return currentSubstring;
        return longestSubstring;
    }

    public static void main(String[] main) {
        System.out.println(longestSubstringWithoutDuplicationImpl("abs"));
    }
}
