package arrays;

import java.util.*;

public class distinctNumbersInWindow {
    static int[] distintNumbersInWindow(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Process the first window
        for (int i = 0; i < k; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        list.add(frequencyMap.size());

        // Process subsequent windows
        for (int i = k; i < nums.length; i++) {
            // Remove the leftmost element from the previous window
            if (frequencyMap.get(nums[i - k]) == 1) {
                frequencyMap.remove(nums[i - k]);
            } else {
                frequencyMap.put(nums[i - k], frequencyMap.get(nums[i - k]) - 1);
            }

            // Add the current element to the current window
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);

            list.add(frequencyMap.size());
        }
        int[] ret = new int[list.size()];

        int i = 0;
        for (int number : list) {
            ret[i] = number;
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distintNumbersInWindow(new int[]{1, 1, 2, 1, 4, 6, 5}, 3)));
    }
}
