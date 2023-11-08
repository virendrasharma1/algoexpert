package recursion;

import java.util.*;

public class subsetSum {
    static boolean combinationSum(int[] A, int val) {
        return recursion(A.length, A, val);
    }

    static boolean recursion(int index, int[] array, int target) {
        if(target == 0) return true;
        if(target < 0) return false;
        if (index == 0) return false;
        return recursion(index-1, array, target) || recursion(index - 1, array, target - array[index-1]);
    }


    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{1, 2, 3}, 4));
    }
}
