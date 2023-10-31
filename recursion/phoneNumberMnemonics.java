package recursion;

import java.util.*;

public class phoneNumberMnemonics {

    public static ArrayList<String> phoneNumberMnemonicsImpl(String phoneNumber) {

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
        ArrayList<String> res = new ArrayList<>();
        phoneNumberMnemonicsImpl(phoneNumber, res, new StringBuilder(), phoneMap, 0);
        return res;

    }

    public static void phoneNumberMnemonicsImpl(String phoneNumber, List<String> result, StringBuilder resString, HashMap<Character, List<String>> map, int activeIndex) {

        if (resString.length() == phoneNumber.length()) {
            result.add(resString.toString());
            return;
        }

        char c = phoneNumber.charAt(activeIndex);
        List<String> phoneMnemonics = map.get(c);

        for (String mnemonic : phoneMnemonics) {
            resString.append(mnemonic);
            phoneNumberMnemonicsImpl(phoneNumber, result, resString, map, activeIndex + 1);
            resString.deleteCharAt(resString.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(phoneNumberMnemonicsImpl("1905"));
    }
}
