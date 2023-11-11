package DP;

public class minCoinsToMakeChange {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[][] memo = new int[n+1][denoms.length];
        int result = minNumberOfCoinsForChange(n, denoms, 0, memo);
        return result == Integer.MAX_VALUE ? -1 : result;

    }
    public static int minNumberOfCoinsForChange(int target, int[] denoms, int index, int[][] memo) {
        if (target == 0) return 0;
        if (target < 0 || index >= denoms.length) return Integer.MAX_VALUE;

        if(memo[target][index] != 0) {
            return memo[target][index];
        }

        int include = minNumberOfCoinsForChange(target - denoms[index], denoms, index, memo);
        if (include != Integer.MAX_VALUE) {
            include += 1;
        }

        int exclude = minNumberOfCoinsForChange(target, denoms, index + 1, memo);

        return memo[target][index] = Math.min(include, exclude);
    }


    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(7, new int[]{1, 5,10}));
    }
}
