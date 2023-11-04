package graphs;

import java.util.HashSet;
import java.util.Set;

public class cycleInGraph {

    public static boolean cycleInGraphImpl(int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        // Write your code here.
        for (int vertex = 0 ; vertex < edges.length ; vertex++) {
            if(ifCycleThere(edges, vertex, visited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean ifCycleThere(int[][] edges, int vertex, Set<Integer> visited) {
        if (visited.contains(vertex)) return true;
        visited.add(vertex);

        for (int child : edges[vertex]) {
            if (ifCycleThere(edges, child, visited)) {
                return true;
            }
        }
        visited.remove(vertex);

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1, 3},
                {0, 2, 3, 4},
                {0},
                {},
                {2, 5},
                {}
        };

//        int[][] edges = new int[][]{
//                {1, 2},
//                {2},
//                {},
//        };
        System.out.println(cycleInGraphImpl(edges));
    }
}
