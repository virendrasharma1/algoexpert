package search;

import java.util.Arrays;

public class searchRange {

    static class Range {
        int[] range;

        Range(int[] range) {
            this.range = range;
        }
    }

    static int[] searchRangeImpl(int[] arr, int key) {
        Range range = new Range(new int[]{-1, -1});
        searchRangeHelper(arr, key, 0, arr.length, range);
        return range.range;
    }

    static void searchRangeHelper(int[] arr, int key, int start, int end, Range range) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if(mid >= arr.length || mid < 0) return;
            if (arr[mid] > key) {
                searchRangeHelper(arr, key, start, mid - 1, range);
            } else if (arr[mid] < key) {
                searchRangeHelper(arr, key, mid + 1, end, range);
            } else {
                if (mid+1 < arr.length && arr[mid + 1] == key) {
                    searchRangeHelper(arr, key, mid + 1, end, range);
                } else {
                    range.range[1] = mid;
                }

                if (mid-1 >=0 && arr[mid - 1] == key) {
                    searchRangeHelper(arr, key, start, mid - 1, range);
                } else {
                    range.range[0] = mid;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRangeImpl(new int[]{1, 2, 3, 3, 3, 4, 4, 5}, 7)));
    }
}
