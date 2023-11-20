package search;

public class searchRotatedSortedArray {

    static int getElementIndex(int[] array, int target) {
        return getElementIndex(array, target, 0, array.length - 1);
    }

    static int getElementIndex(int[] array, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;

        if (array[mid] == target) return mid;
        // Left half is sorted
        if (array[start] <= array[mid]) {
            if (array[start] <= target && array[mid] > target) {
                return getElementIndex(array, target, start, mid - 1);
            } else {
                return getElementIndex(array, target, mid + 1, end);
            }
        } else {
            if (array[end] >= target && array[mid] < target) {
                return getElementIndex(array, target, start, mid - 1);
            } else {
                return getElementIndex(array, target, mid + 1, end);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(getElementIndex(new int[]{4, 5, 6, 7, 1, 2, 3}, 6));
    }
}
