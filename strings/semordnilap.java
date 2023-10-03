package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class semordnilap {

    public static ArrayList<ArrayList<String>> semordnilapImpl(String[] words) {
        // Write your code here.
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));

        ArrayList<ArrayList<String>> semordnilapPairs = new ArrayList<>();

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();

            if (wordsSet.contains(reverse) && !reverse.equals(word)) {
                ArrayList<String> pair = new ArrayList<>();
                pair.add(word);
                pair.add(reverse);

                semordnilapPairs.add(pair);
                wordsSet.remove(word);
                wordsSet.remove(reverse);
            }
        }
        return semordnilapPairs;
    }

    public static void main(String[] args) {
        System.out.println(semordnilapImpl(new String[]{"diaper", "abc", "test", "cba", "repaid"}));
    }

}
