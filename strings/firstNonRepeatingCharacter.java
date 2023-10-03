package strings;

import java.util.HashSet;
import java.util.Set;

public class firstNonRepeatingCharacter {

    public static int firstNonRepeatingCharacterImpl(String string) {
        Set<Character> set = new HashSet<>();

        int response = -1;
        for (int i = 0; i < string.length(); i++) {
            if (string.lastIndexOf(string.charAt(i)) == i && !set.contains(string.charAt(i))) {
                return i;
            } else {
                set.add(string.charAt(i));
            }
        }
        return response;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacterImpl("abcdcaf"));
    }
}
