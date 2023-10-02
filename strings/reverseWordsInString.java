package strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class reverseWordsInString {

    public static String reverseWordsInStringImpl(String string) {
        List<String> words = new ArrayList<>();

        int start = 0;

        for (int i = 0 ; i < string.length() ; i++) {
            char character = string.charAt(i);

            if (character == ' ') {
                words.add(string.substring(start, i));
                start = i;
            } else if (string.charAt(start) == ' ') {
                words.add(" ");
                start = i;
            }
        }

        words.add(string.substring(start));
        Collections.reverse(words);
        return String.join("", words);
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInStringImpl("AlgoExpert is the Best!"));
    }
}
