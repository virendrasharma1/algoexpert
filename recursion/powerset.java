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

    public static void main(String[] args) {
        System.out.println(powersetImpl(new ArrayList<Integer>(List.of(1, 2, 3))));
    }
}
