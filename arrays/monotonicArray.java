package arrays;

/*
Time - O(n) as while loop is O(n) and next loop also O(1)
Space - O(1) as integers are constanr
 */
public class monotonicArray {

    public static boolean isMonotonicAnother(int[] array) {
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;

        for (int i = 1 ; i < array.length ; i++) {
            if (array[i] > array[i-1]) {
                isNonDecreasing = false;
            }

            if (array[i] < array[i-1]) {
                isNonIncreasing = false;
            }
        }
        return isNonDecreasing || isNonIncreasing;
    }

    public static boolean isMonotonic(int[] array) {
        if (array.length == 0 || array.length == 1) return true;
        int firstElement = array[0];
        int length = array.length - 1;
        int lastElement = array[length];

        if (firstElement == lastElement) {
            while (lastElement == firstElement && length > 0) {
                lastElement = array[length];
                length--;
            }
        }

        if (firstElement == lastElement) return true;

        String isIncreasingOrDecreasing = "";

        if (firstElement > lastElement) {
            isIncreasingOrDecreasing = "DECREASING";
        } else {
            isIncreasingOrDecreasing = "INCREASING";

        }
        int prevElementValue = array[0];
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            if (isIncreasingOrDecreasing.equals("DECREASING")) {
                if (prevElementValue >= element) {
                    prevElementValue = element;
                } else {
                    return false;
                }
            } else {
                if (prevElementValue <= element) {
                    prevElementValue = element;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
