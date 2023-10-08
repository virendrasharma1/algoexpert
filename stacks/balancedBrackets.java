package stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class balancedBrackets {

    public static boolean balancedBracketsImpl(String str) {
        List<Character> openingBrackets = new ArrayList<>(List.of('(', '[', '{'));
        List<Character> closingBrackets = new ArrayList<>(List.of(')', ']', '}'));

        Stack<Character> charStack = new Stack<>();

        for (int i = 0 ; i < str.length() ; i++) {
            if (openingBrackets.contains(str.charAt(i))) {
                charStack.add(str.charAt(i));
            } else if (closingBrackets.contains(str.charAt(i))) {
                if (charStack.isEmpty()) return false;
                Character latestChar = charStack.pop();
                if (!(openingBrackets.indexOf(latestChar) == closingBrackets.indexOf(str.charAt(i)))) {
                    return false;
                }
            }
        }

        // Write your code here.
        return charStack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(balancedBracketsImpl("(a)"));
    }
}
