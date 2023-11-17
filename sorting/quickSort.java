package sorting;

import java.util.Arrays;

public class quickSort {

    static void quickSortImpl(int[] array) {
        quickSortImpl(array, 0, array.length - 1);
    }

    static void quickSortImpl(int[] array, int start, int end) {
        if (end < start) return;
        int partitionIndex = getPartitionIndex(array, start, end);

        quickSortImpl(array, start, partitionIndex - 1);
        quickSortImpl(array, partitionIndex + 1, end);
    }

    static int getPartitionIndex(int[] array, int start, int end) {

        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, end);
        return i + 1;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{29, 28, 7, 91, 2, 3};
        System.out.println(Arrays.toString(array));
        quickSortImpl(array);
        System.out.println(Arrays.toString(array));
    }
}
