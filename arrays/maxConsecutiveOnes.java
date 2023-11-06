package arrays;

import java.util.Arrays;

public class maxConsecutiveOnes {
    static int getMaxConsecutiveOnes(int[] A) {
        int maximumCounter = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == 1) {
                int counter = 1;
                int j = i + 1;
                while (j < A.length && A[j] == 1) {
                    j++;
                    counter++;
                }
                if (counter > maximumCounter) {
                    maximumCounter = counter;
                }
                i = j;
            }
        }
        return maximumCounter;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 3, 3, 1, 1, 1};
        System.out.println(getMaxConsecutiveOnes(array));
    }
}
