package twoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class maximumKSubarraySum {
    static int[] maxKSubarraySum(int[] A, int k) {
        int[] maxSumArray = new int[A.length - k + 1];
        int count = 0;
        for (int i = 0; i < A.length - k + 1; i++) {
            int j = i + k - 1;
            int currentSum = 0;
            while (j >= i) {
                currentSum += A[j];
                j--;
            }
            maxSumArray[count] = currentSum;
            count++;
        }
        return maxSumArray;
    }

    static int[] maxKSubarraySumDifferent(int[] A, int k) {
        int n = A.length;
        int[] list = new int[n - k + 1];
        int sum = 0;
        int iterator = 0;
        for(int i = 0; i < k; i++) {
            sum += A[i];
        }
        list[iterator] = sum;
        iterator++;
        for(int i = k; i < n; i++) {
            sum -= A[i - k];
            sum += A[i];
            list[iterator] = sum;
            iterator++;
        }
        return list;
    }

    static int getSumFromQueue(Queue<Integer> queue) {
        Queue<Integer> q = new LinkedList<>(queue);

        int sum = 0;

        while(!q.isEmpty()) {
            sum+=q.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxKSubarraySumDifferent(new int[]{3, 5, 6, 2, 4, 7, 8}, 3)));
    }
}
