package sorting;

import java.util.Arrays;

public class selectionSort {

    public static void selectionSortImpl(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minimumElementIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minimumElementIndex]) {
                    minimumElementIndex = j;
                }
            }
            int temp = array[minimumElementIndex];
            array[minimumElementIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{29, 28, 7, 91, 2, 3};
        System.out.println(Arrays.toString(array));
        selectionSortImpl(array);
        System.out.println(Arrays.toString(array));
    }
}
