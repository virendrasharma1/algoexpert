package arrays;

import java.util.*;

public class threeNumberSum {

    public static List<Integer[]> threeNumberSumImpl(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> resultlist = new ArrayList<>();
        for (int i = 0; i < array.length-2; i++) {
            int value = array[i];

            int start =  i +1;
            int last = array.length - 1;

            while (start < last) {
                int restValue = array[start] + array[last];
                if (value + restValue > targetSum) {
                    last--;
                } else if (value + restValue < targetSum) {
                    start++;
                } else {
                    Integer[] tempList = new Integer[]{value, array[start], array[last]};
                    resultlist.add(tempList);
                    last--;
                    start++;
                }
            }
        }
        return resultlist;
    }

    public static void main(String[] args) {
        System.out.println(threeNumberSumImpl(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0));
    }
}
//-8,  -6, 1,2,3,5,6,12