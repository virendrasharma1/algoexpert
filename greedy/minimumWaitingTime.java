package greedy;

import java.util.Arrays;

public class minimumWaitingTime {

    public static int minimumWaitingTimeImpl(int[] queries) {
        // Write your code here.
        Arrays.sort(queries);

        if (queries.length == 1) {
            return 0;
        }
        int totalTime = queries[0];
        for (int i = 1; i < queries.length - 1; i++) {
            queries[i] = queries[i] + queries[i - 1];
            totalTime += queries[i];
        }
        return totalTime;
    }

    public static void main(String[] args) {

        int[] queries = new int[]{3, 2, 1, 2, 6};
        System.out.println(minimumWaitingTimeImpl(queries));
    }
}
