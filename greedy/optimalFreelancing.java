package greedy;

import java.util.*;

public class optimalFreelancing {

    public static int optimalFreelancingImpl(Map<String, Integer>[] jobs) {

        Arrays.sort(jobs, (o1, o2) -> o2.get("payment").compareTo(o1.get("payment")));
        // Write your code here.
        boolean[] weekArray = new boolean[7];

        int profit = 0;
        for (Map<String, Integer> job : jobs) {
            int maxTime = Math.min(job.get("deadline"), 7);
            for (int i = maxTime-1; i >= 0; i--) {
                if (!weekArray[i]) {
                    weekArray[i] = true;
                    profit += job.get("payment");
                    break;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {

        Map<String, Integer>[] jobs = new Map[]{
                Map.of("deadline", 1, "payment", 1),
                Map.of("deadline", 2, "payment", 1),
                Map.of("deadline", 3, "payment", 1),
                Map.of("deadline", 4, "payment", 1),
                Map.of("deadline", 5, "payment", 1),
                Map.of("deadline", 6, "payment", 1),
                Map.of("deadline", 6, "payment", 1),
                Map.of("deadline", 7, "payment", 1),
                Map.of("deadline", 8, "payment", 1),
                Map.of("deadline", 9, "payment", 1),
                Map.of("deadline", 10, "payment", 1),
        };
        System.out.println(optimalFreelancingImpl(jobs));
    }
}
