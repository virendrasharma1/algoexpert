package recursion;

import java.util.*;

public class phoneNumberMnemonics {

    public static List<String> phoneNumberMnemonicsImpl(String phoneNumber) {

        HashMap<Character, List<String>> phoneMap = new HashMap<>();
        phoneMap.put('0', new ArrayList<>(List.of("0")));
        phoneMap.put('1', new ArrayList<>(List.of("1")));
        phoneMap.put('2', new ArrayList<>(List.of("a", "b", "c")));
        phoneMap.put('3', new ArrayList<>(List.of("d", "e", "f")));
        phoneMap.put('4', new ArrayList<>(List.of("g", "h", "i")));
        phoneMap.put('5', new ArrayList<>(List.of("j", "k", "l")));
        phoneMap.put('6', new ArrayList<>(List.of("m", "n", "o")));
        phoneMap.put('7', new ArrayList<>(List.of("p", "q", "r", "s")));
        phoneMap.put('8', new ArrayList<>(List.of("t", "u", "v")));
        phoneMap.put('9', new ArrayList<>(List.of("w", "x", "y", "z")));

        List<String> res = new ArrayList<>();
        res.add("");

        for (int i = 0; i < phoneNumber.length(); i++) {
            List<String> newList = new ArrayList<>();
            Character c = phoneNumber.charAt(i);
            for (String string : phoneMap.get(c)) {
                for (String re : res) {
                    newList.add(re + string);
                }
            }
            res = newList;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(phoneNumberMnemonicsImpl("1905"));
    }
}
