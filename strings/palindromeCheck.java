package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class palindromeCheck {

    public static boolean isPalindrome(String str) {
        // Write your code here.
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdcba"));
    }
}
