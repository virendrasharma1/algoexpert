package arrays;

import java.util.Arrays;

/*
O(nlogn) - Time - Arrays.sort is O(nlogn) and while loop is o(n) so this makes it o(nlogn)
O(1) - Space does not depend upon the size of input array
 */
public class sweetAndSavoury {

    public static int[] sweetAndSavory(int[] dishes, int target) {
        // Write your code here.
        Arrays.sort(dishes);

        if (dishes.length == 0 || dishes[0] > 0 || dishes[dishes.length -1] < 0) {
            return new int[]{0, 0};
        }

        int closenessToTarget = Integer.MAX_VALUE;

        int[] returnArray = new int[]{0, 0};

        int start = 0;
        int end = dishes.length - 1;

        while (end > start && dishes[start] < 0 && dishes[end] > 0) {
            int difference = dishes[start] + dishes[end];

            int close = Math.abs(target - difference);
            if (closenessToTarget > close && dishes[end] <= target) {
                closenessToTarget = close;
                returnArray[0] = dishes[start];
                returnArray[1] = dishes[end];
            }
            if (difference > target) {
                end--;
            } else {
                start++;
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, -4, -7, 12, 100, -25};
        int target = 20;

        System.out.println(Arrays.toString(sweetAndSavory(array, target)));

    }
}
