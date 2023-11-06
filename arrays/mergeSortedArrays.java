package arrays;

import java.util.Arrays;

public class mergeSortedArrays {
    static int[] mergeSortedArraysImpl(int[] A, int[] B) {
        int[] newArray = new int[A.length + B.length];

        int aStart = 0;
        int bStart = 0;
        int activeNewArrayIndex = 0;
        while(aStart < A.length && bStart < B.length) {
            if(A[aStart] >= B[bStart]) {
                newArray[activeNewArrayIndex] = B[bStart];
                bStart++;
            } else {
                newArray[activeNewArrayIndex] = A[aStart];
                aStart++;
            }
            activeNewArrayIndex++;
        }
        if(aStart != A.length) {
            while(aStart < A.length) {
                newArray[activeNewArrayIndex] = A[aStart];
                aStart++;
                activeNewArrayIndex++;
            }
        }

        if(bStart != B.length) {
            while(bStart < B.length) {
                newArray[activeNewArrayIndex] = B[bStart];
                bStart++;
                activeNewArrayIndex++;
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArraysImpl(new int[]{1,2,3,4,4}, new int[]{8})));
    }
}
