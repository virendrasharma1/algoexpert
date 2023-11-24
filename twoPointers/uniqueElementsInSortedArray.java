package twoPointers;

import java.util.HashSet;
import java.util.Set;

public class uniqueElementsInSortedArray {

    static int removeDuplicates(int[] A) {
        int count = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] != A[i + 1]) {
                count++;
            }
        }

        return count;
    }

    static int removeDuplicatesSet(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int j : A) {
            set.add(j);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 3, 3, 3, 4, 4}));
    }
}
//