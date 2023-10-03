package strings;

import java.util.HashMap;

public class generateDocument {

    public static boolean generateDocumentImpl(String characters, String document) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {
            charCount.put(characters.charAt(i), charCount.getOrDefault(characters.charAt(i), 0) + 1);
        }

        for (int i = 0; i < document.length(); i++) {
            if (!charCount.containsKey(document.charAt(i)) || charCount.get(document.charAt(i)) == 0) {
                return false;
            }
            charCount.put(document.charAt(i), charCount.get(document.charAt(i)) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(generateDocumentImpl("Bste!hetsi ogEAxpelrt x", "AlgoExpert is the Best!"));
    }
}
