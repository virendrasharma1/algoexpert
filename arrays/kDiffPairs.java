package arrays;

public class kDiffPairs {
    static int kDiffPairsImpl(int[] A, int k) {
        int ret = 0;
        for (int i = 0 ; i < A.length ; i++) {
            for (int j = i ; j < A.length ; j++) {
                if((A[j] - A[i]) == k) {
                    ret++;
                }
            }
        }
        return ret;
    }

    static int kDiffPairsImplProper(int[] A, int k) {
        int firstPointer = 0;
        int secondPointer = 1;
        int count = 0;

        while(secondPointer < A.length) {
            while (secondPointer < (A.length - 1) && A[secondPointer] == A[secondPointer + 1]) {
                secondPointer++;
            }
            if(A[secondPointer] - A[firstPointer] == k) {
                firstPointer++;
                secondPointer++;
                count++;
            } else if (A[secondPointer] - A[firstPointer] > k) {
                firstPointer++;
            } else {
                secondPointer++;
            }
            if(firstPointer == secondPointer) secondPointer++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(kDiffPairsImplProper(new int[]{1, 3, 5, 7, 10}, 5));
    }
}
