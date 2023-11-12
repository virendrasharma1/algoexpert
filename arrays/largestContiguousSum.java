package arrays;

public class largestContiguousSum {

    static int largestContiguousSumImpl(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            maxEndingHere = Math.max(maxEndingHere, maxEndingHere+num);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);

        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(largestContiguousSumImpl(new int[]{-1, 2, -3}));
    }
}
