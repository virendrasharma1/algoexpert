package arrays;

import java.util.*;

/*
Space complexity - O(n) as res constructing is equal to intervals O(n)
Time complexity - O(nlogn) sorting is O(nlogn) iteration - O(n)
 */
public class mergeOverlappingIntervals {
    public static int[][] mergeOverlappingIntervalsImpl(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int intervalStart = 0;
        int interValEnd = 0;
        int reslength = 0;
        int[][] res = new int[intervals.length][2];
        for (int[] record : intervals) {
            if (record[0] >= intervalStart && record[0] <= interValEnd) {
                interValEnd = Math.max(record[1], interValEnd);
                if (reslength > 0) {
                    res[reslength - 1][1] = interValEnd;
                } else {
                    res[0][1] = interValEnd;
                    res[0][0] = intervalStart;
                    reslength++;
                }
            } else {
                intervalStart = record[0];
                interValEnd = record[1];
                res[reslength][0] = intervalStart;
                res[reslength][1] = interValEnd;
                reslength++;
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int[] record : res) {
            List<Integer> l = Arrays.stream(record).boxed().toList();
            if (!list.contains(l) && !l.equals(new ArrayList<>(List.of(0, 0)))) {
                list.add(l);
            }
        }

        int[][] result = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }

        if (result.length == 0) return new int[][]{{0, 0}};
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(mergeOverlappingIntervalsImpl(new int[][]{{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}})));
        System.out.println(Arrays.toString(mergeOverlappingIntervalsImpl(new int[][]{{0, 0}, {0, 0}})));
    }
}
