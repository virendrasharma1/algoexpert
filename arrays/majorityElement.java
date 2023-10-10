package arrays;

import java.util.HashMap;

public class majorityElement {

    public static int majorityElementImpl(int[] array) {
        // Write your code here.
        int[] map = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int element : array) {
            if (map[0] == element) {
                map[1] = map[1] + 1;
            } else if (map[0] == Integer.MIN_VALUE) {
                map[0] = element;
                map[1] = 1;
            } else {
                if (map[1] > 1) {
                    map[1] = map[1] - 1;
                } else if (map[1] == 1) {
                    map[0] = Integer.MIN_VALUE;
                    map[1] = Integer.MIN_VALUE;
                }
            }
        }
        return map[0];
    }

    public static void main(String[] args) {
        System.out.println(majorityElementImpl(new int[]{1, 2, 3, 2, 2, 1, 2}));
    }
}
