package arrays;

import java.util.Arrays;

public class squareSortedArray {

    static int[] getSquareSortedArray(int[] arr) {
        int[] newArray = new int[arr.length];

        int startIndex = 0;
        int endIndex = arr.length - 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int startValue = Math.abs(arr[startIndex]);
            int endValue = Math.abs(arr[endIndex]);

            if (startValue >= endValue) {
                newArray[i] = startValue * startValue;
                startIndex++;
            } else {
                newArray[i] = endValue * endValue;
                endIndex--;
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-6, -1, 3, 5};
        System.out.println(Arrays.toString(getSquareSortedArray(array)));
    }
}
