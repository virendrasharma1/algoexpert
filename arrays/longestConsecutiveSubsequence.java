package arrays;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveSubsequence {

    static int longestConsecutiveSequence(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        int longestSequenceLength = 1;

        boolean flag = false;

        for (Integer num : set) {
            if (set.contains(num - 1)) {

            } else if (set.contains(num+1)) {
                int current = 0;
                int currentNumber = num;
                while (set.contains(currentNumber)) {
                    current++;
                    longestSequenceLength = Math.max(current, longestSequenceLength);
                    currentNumber++;
                }
            }
        }
        return longestSequenceLength;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutiveSequence(new int[]{24, 2, 34, 1, 3, 4, 3, -1, 28, 0}));
    }
}
