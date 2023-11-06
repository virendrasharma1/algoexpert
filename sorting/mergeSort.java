package sorting;

import java.util.Arrays;

public class mergeSort {

    public static void mergeSortImpl(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int mid = (array.length) / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Split the array into left and right halves
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        mergeSortImpl(left);
        mergeSortImpl(right);
        merge(array, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        // Compare elements from left and right arrays and merge them into arr[]
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of left[] and right[] if any
        while (i < leftLength) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{29, 28, 7, 91, 2, 3};
        System.out.println(Arrays.toString(array));
        mergeSortImpl(array);
        System.out.println(Arrays.toString(array));
    }
}
