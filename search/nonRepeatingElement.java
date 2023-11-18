package search;

public class nonRepeatingElement {

    static int findNonRepeatingElement(int[] arr) {
        return findNonRepeatingElement(arr, 0, arr.length - 1);
    }

    static int findNonRepeatingElement(int[] arr, int start, int end) {
        if (end < start) return 0;
        int mid = (start + end) / 2;
        if (end == start) return arr[mid];

        if (mid % 2 == 0) {
            if (arr[mid] == arr[mid + 1]) {
                return findNonRepeatingElement(arr, mid + 1, end);
            } else {
                return findNonRepeatingElement(arr, start, mid);
            }
        } else {
            if (arr[mid] == arr[mid - 1]) {
                return findNonRepeatingElement(arr, mid + 1, end);
            } else {
                return findNonRepeatingElement(arr, start, mid);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findNonRepeatingElement(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5}));
    }
}
