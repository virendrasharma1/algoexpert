package recursion;

import java.util.ArrayList;
import java.util.List;

public class generateParentheses {
    static List<String> generateParenthesesImpl(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesesImplHelper(n, n, result, "");
        return result;
    }

    static void generateParenthesesImplHelper(int openCount, int closeCount, List<String> result, String currentString) {
        if (openCount == 0 && closeCount == 0) {
            result.add(currentString);
            return;
        }

        if (openCount > 0) {
            currentString = currentString + '(';
            generateParenthesesImplHelper(openCount - 1, closeCount, result, currentString);
            currentString = currentString.substring(0, currentString.length() - 1);
        }

        if (closeCount > 0) {
            if (openCount < closeCount) {
                currentString = currentString + ')';
                generateParenthesesImplHelper(openCount, closeCount - 1, result, currentString);
                currentString = currentString.substring(0, currentString.length() - 1);
            }
        }


    }

    public static void main(String[] args) {
        System.out.println(generateParenthesesImpl(3));
    }
}
