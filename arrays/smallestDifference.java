package arrays;

import java.util.Arrays;

/*
Space - O(1) as it is constant space
Time - Sorting takes O(nlogn) and there are two sortings so total is O(nlogn + mlogm)
 */
public class smallestDifference {

    public static int[] smallestDifferenceImpl(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int arrayOneLength = 0;
        ;
        int arrayTwoLength = 0;
        int difference = Integer.MAX_VALUE;

        int[] result = new int[2];
        while (arrayOneLength <= arrayOne.length - 1 && arrayTwoLength <= arrayTwo.length - 1) {
            int arrayOneValue = arrayOne[arrayOneLength];
            int arrayTwoValue = arrayTwo[arrayTwoLength];
            int diff = Math.abs(arrayOneValue - arrayTwoValue);
            if (diff < difference) {
                difference = diff;
                result[0] = arrayOneValue;
                result[1] = arrayTwoValue;
            }
            if (arrayOneValue > arrayTwoValue) {
                arrayTwoLength++;
            } else if (arrayOneValue < arrayTwoValue) {
                arrayOneLength++;
            } else {
                return new int[]{arrayOneValue, arrayTwoValue};
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                smallestDifferenceImpl(
                        new int[]{-1, 5, 10, 20, 28, 3},
                        new int[]{26, 134, 135, 55, 17})));
    }
}
