package recursion;

import java.util.ArrayList;
import java.util.List;

public class restoreIPAddresses {

    static List<String> restoreIPAddressesImpl(String s) {
        List<String> list = new ArrayList<>();
        restoreIPAddressesImpl(s, list, new ArrayList<>(), 0);
        return list;
    }

    static void restoreIPAddressesImpl(String s, List<String> resultList, List<String> currentString, int startIndex) {
        if (startIndex == s.length() && currentString.size() == 4) {
            resultList.add(String.join(".", currentString));
            return;
        }

        for (int i = startIndex + 1; i <= s.length() && i <= startIndex + 3; i++) {
            String segment = s.substring(startIndex, i);
            if (isValidSegment(segment)) {
                currentString.add(segment);
                restoreIPAddressesImpl(s, resultList, currentString, i);
                currentString.remove(currentString.size() - 1);
            }
        }
    }

    static boolean isValidSegment(String segment) {
        if(segment.length() > 1 && segment.startsWith("0")) return false;

        int num = Integer.parseInt(segment);

        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        System.out.println(restoreIPAddressesImpl("1921680"));
    }

}
