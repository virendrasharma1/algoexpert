package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class commonCharacters {

    public static String[] commonCharactersImpl(String[] strings) {
        // Write your code here.
        HashMap<Character, Integer> map = new HashMap<>();

        for (String s : strings) {
            Set<Character> charSet = s.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toSet());


            charSet.forEach(c -> map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1));

        }
        return map.entrySet().stream().filter(mapVal -> mapVal.getValue() == strings.length).map(entry -> entry.getKey().toString()).toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(commonCharactersImpl(new String[]{"abc", "bcd", "cbaccd"})));
    }
}
