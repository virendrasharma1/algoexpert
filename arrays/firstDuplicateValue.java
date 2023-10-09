package arrays;

import java.util.HashSet;

public class firstDuplicateValue {

    public static int firstDuplicateValueImpl(int[] array) {
        // Write your code here.
        HashSet<Integer> set = new HashSet<>();

        for (int value: array) {
            if (set.contains(value)) {
                return value;
            } else {
                set.add(value);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(firstDuplicateValueImpl(new int[] {2, 1, 5, 2, 3, 3, 4}));
    }
}
