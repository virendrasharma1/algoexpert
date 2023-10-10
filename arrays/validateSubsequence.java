package arrays;

import java.util.List;

/*
O(n) time O(1) space
 */
public class validateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int counter = 0;
        for (int value : array) {
            if (value == sequence.get(counter)) {
                counter++;
            }
            if (counter == sequence.size()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, 10)));
    }
}
