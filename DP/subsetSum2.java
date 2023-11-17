package DP;

import java.util.Arrays;

public class subsetSum2 {

    static int subsetSum(int[] A, int target) {
        int[][] dp = new int[A.length + 1][target + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        boolean value = recursion(A, target, A.length, dp);
        System.out.println(value);
        return value ? 1 : 0;
    }

    static boolean recursion(int[] A, int target, int index, int[][] dp) {
        if (target == 0) {
            dp[index][target] = 1;
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (index == 0) return false;
        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }
        dp[index][target] = recursion(A, target, index - 1, dp) || recursion(A, target - A[index - 1], index - 1, dp) ? 1 : 0;
        return dp[index][target] == 1;
    }

    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{3, 0, 4, 9, 5}, 10));
    }
}
