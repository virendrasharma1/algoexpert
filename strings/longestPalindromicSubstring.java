package strings;

public class longestPalindromicSubstring {

    public static String longestPalindromicSubstring(String str) {

        if (str.length() == 1) {
            return str;
        }
        String longestPalindromicString = "";
        for (int i = 1; i < str.length() - 1; i++) {
            String even = longestString(String.valueOf(str.charAt(i)), i-1, i+1, str);
            if (longestPalindromicString.length() < even.length()) {
                longestPalindromicString = even;
            }
            String odd = longestString("", i, i+1, str);
            if (longestPalindromicString.length() < odd.length()) {
                longestPalindromicString = odd;
            }
        }
        return longestPalindromicString;
    }

    public static String longestString (String s, int start, int end, String str) {
        StringBuilder builder = new StringBuilder(s);

        while ((start >= 0 && end < str.length()) && str.charAt(start) == str.charAt(end)) {
            builder = new StringBuilder(String.valueOf(str.charAt(start)) + builder + String.valueOf(str.charAt(end)));
            start--;
            end++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
        System.out.println(longestPalindromicSubstring("a"));
    }
}
