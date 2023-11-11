package DP;

import java.util.Arrays;

public class maxSubsetSum {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        int[] memo = new int[array.length];
        Arrays.fill(memo, -1);
        return maxSubsetSumNoAdjacent(array, 0, memo);
    }

    public static int maxSubsetSumNoAdjacent(int[] array, int index, int[] memo) {

        if(index >= array.length) return 0;

        if(memo[index]  != -1) {
            return memo[index];
        }
        int including = array[index] + maxSubsetSumNoAdjacent(array, index+2, memo);

        int excluding = maxSubsetSumNoAdjacent(array, index+1, memo);

        return memo[index] = Math.max(including, excluding);
    }


    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{75, 105, 120, 75, 90, 135}));
    }
}
