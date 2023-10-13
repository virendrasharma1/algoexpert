package search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class findThreeLargestNumbers {

    public static int[] findThreeLargestNumbersImpl(int[] array) {
        int[] res = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int element: array) {
            if (element >= res[2]) {
                res[0] = res[1];
                res[1] = res[2];
                res[2] = element;
            } else if (element >= res[1]) {
                res[0] = res[1];
                res[1] = element;
            } else if (element >= res[0]) {
                res[0] = element;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThreeLargestNumbersImpl(new int[]{7, 7, 7, 7, 7,7})));
    }
}
