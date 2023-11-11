package DP;

public class maxWaysToMakeChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[][] memo = new int[n+1][denoms.length];
        return numberOfWaysToMakeChange(n, denoms, 0, memo);
    }

    static int numberOfWaysToMakeChange(int target, int[] demons, int index, int[][] memo) {
        if(index >= demons.length) return 0;
        if(target < 0) return 0 ;
        if(target == 0) {
            return 1;
        }
        if (memo[target][index] != 0) {
            return memo[target][index];
        }
        return memo[target][index] = numberOfWaysToMakeChange(target - demons[index], demons, index, memo) + numberOfWaysToMakeChange(target, demons, index + 1, memo);
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(6, new int[]{1, 5}));
    }
}
