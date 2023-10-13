package search;

public class binarySearch {

    public static int binarySearchImpl(int[] array, int target) {

        int last = array.length - 1;
        int first = 0;


        return binarySearchImpl(array, target, last, first);
    }

    private static int binarySearchImpl(int[] array, int target, int last, int first) {
        int mid = (last + first) / 2;

        if (last < first) return -1;
        if (array[mid] > target) {
            return binarySearchImpl(array, target, mid - 1, first);
        } else if (array[mid] < target) {
            return binarySearchImpl(array, target, last, mid + 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearchImpl(new int[]{1, 5, 23, 111}, 120));
    }
}
