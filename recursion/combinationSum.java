package recursion;

import java.util.*;

class combinationSum {
    static List<List<Integer>> combinationSumImpl(int[] A, int val) {
        List<List<Integer>> resultSet = new ArrayList<>();
        combinationSumImplHelper(A, resultSet, val, new ArrayList<>(), 0);
        return new ArrayList<>(resultSet);
    }

    public static void combinationSumImplHelper(int[] array, List<List<Integer>> resultList, int currentSum, ArrayList<Integer> currentList, int index) {
        if (currentSum == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }

        if (currentSum < 0) {
            return;
        }

        if (index == array.length) return;
        currentList.add(array[index]);
        combinationSumImplHelper(array, resultList, currentSum - array[index], currentList, index);
        currentList.remove(currentList.size() - 1);
        combinationSumImplHelper(array, resultList, currentSum, currentList, index+1);
    }

    public static void main(String[] args) {
        System.out.println(combinationSumImpl(new int[]{1, 2}, 4));
    }
}