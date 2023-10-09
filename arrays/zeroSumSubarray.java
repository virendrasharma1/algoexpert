package arrays;

import java.util.ArrayList;
import java.util.List;

/*
Time - O(n2) as there is a single while loop but sumlists.contains also has O{n) Instead we can use Hashset which will be O(1)
Space - O(1) as arraylist is irrespective of size of array
 */
public class zeroSumSubarray {
    public static boolean zeroSumSubarrayImpl(int[] nums) {
        List<Integer> sumLists = new ArrayList<>();

        if (nums.length == 1) {
            return nums[0] == 0;
        }
        if (nums.length == 2) {
            return nums[1] + nums[0] == 0;
        }
        int sum = 0;

        for (int num : nums) {
            sum+=num;
            if (sumLists.contains(sum)) {
                return true;
            }
            sumLists.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-5, -5, 2, 3, -2};
        System.out.println(zeroSumSubarrayImpl(array));

    }
}
