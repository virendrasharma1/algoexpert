package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
O(n) - There is a while loop and for loop and stream for both it is n that's why n, for removal also it is o((n)
O(1) - Hashset will store the num + 2 so it is o(n) again
 */
public class missingNumbers {

    public static int[] missingNumbersImpl(int[] nums) {

        int totalLength = nums.length + 2;
        Set<Integer> containingSet = new HashSet<>();
        while (totalLength > 0) {
            containingSet.add(totalLength);
            totalLength--;
        }

        for(int num: nums) {
            containingSet.remove(num);
        }
        return Arrays.stream(containingSet.toArray()).mapToInt(obj -> (int) obj).toArray();
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 3};
        System.out.println(Arrays.toString(missingNumbersImpl(array)));

    }
}
