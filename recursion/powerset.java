package recursion;

import java.util.ArrayList;
import java.util.List;

public class powerset {

    public static List<List<Integer>> powersetImpl(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> resultPowerSet = new ArrayList<>();
        resultPowerSet.add(new ArrayList<>());

        for (Integer element : array) {
            int subsetSize = resultPowerSet.size();
            for (int i = 0; i < subsetSize; i++) {
                List<Integer> currentPowerSet = new ArrayList<>(resultPowerSet.get(i));
                currentPowerSet.add(element);
                resultPowerSet.add(currentPowerSet);
            }
        }
        return resultPowerSet;
    }

    public static List<List<Integer>> powerSetRecursive(int[] array) {
        List<List<Integer>> resultPowerSet = new ArrayList<>();
        recursion(0, array, new ArrayList<>(), resultPowerSet);
        return resultPowerSet;
    }

    public static void recursion(int index, int[] array, List<Integer> currentList, List<List<Integer>> res) {
        res.add(new ArrayList<>(currentList));

        for(int i = index; i < array.length; i++) {
            currentList.add(array[i]);
            recursion(i+1, array, currentList, res);
            currentList.remove(currentList.size()-1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(powerSetRecursive(new ArrayList<Integer>(List.of(1, 2, 3))));
    }
}
