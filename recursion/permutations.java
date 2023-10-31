package recursion;

import java.util.ArrayList;
import java.util.List;

/*
Time complexity - O(n*n!) as first we are looping through n integers in array and then looping again recursively to n!
Space complexity - O(n*n!) as n! space is taken by resultList
 */
public class permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {

        ArrayList<List<Integer>> resultList = new ArrayList<>();
        if (array.isEmpty()) return resultList;
        getPermutations(array, resultList, new ArrayList<>());
        return resultList;
    }

    public static void getPermutations(List<Integer> array, ArrayList<List<Integer>> resultList, List<Integer> tempList) {

        if (tempList.size() == array.size()) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int number : array) {
            if (tempList.contains(number)) continue;;
            tempList.add(number);
            getPermutations(array, resultList, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getPermutations(new ArrayList<>(List.of(1, 2, 3))));
    }
}
