package search;

import java.util.Arrays;

public class quickSelect {

    public static int quickSelectImpl(int[] array, int k) {

        return quickSelectImpl(array, 0, array.length - 1, k-1);
    }

    static int quickSelectImpl(int[] array, int start, int end, int k) {

        int partitionIndex = getPartitionIndex(array, start, end);

        if (partitionIndex == k) return array[partitionIndex];

        if (partitionIndex > k) {
            return quickSelectImpl(array, start, partitionIndex - 1, k);
        } else {
            return quickSelectImpl(array, partitionIndex + 1, end, k);
        }
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
        int[] array = new int[]{4,3,2,1};
        System.out.println(Arrays.toString(array));
        System.out.println(quickSelectImpl(array, 1));
    }
}
