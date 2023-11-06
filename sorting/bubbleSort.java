package sorting;

import java.util.Arrays;

public class bubbleSort {

    public static int[] bubbleSortImpl(int[] array) {
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = 0 ; j < array.length -1 ; j++) {
                if(array[j+1] < array[j]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;

                }
            }
        }
        return array;
    }

    public static int[] bubbleSortImplDifferent(int[] array) {
        boolean isSorted = false;
        int counter = 0;

        while(!isSorted) {
            isSorted = true;

            for (int i = 0 ; i< array.length - 1 - counter ; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = new int[]{29, 28, 7, 91, 2, 3};
        System.out.println(Arrays.toString(bubbleSortImpl(array)));
    }
}
