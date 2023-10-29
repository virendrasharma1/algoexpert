package stacks;

import java.util.*;

/*
Space complexity - O(m*n) as we are creating visited array and call stack worse also can be O(m*n) if every node is visited, moreover, list also can contain every single so worst case is O(m*n)
Time complexity - Since there are two loops so O(m*n)
 */
public class riverSizes {

    public static List<Integer> riverSizesImpl(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    list.add(dfs(matrix, i, j, visited));
                }
            }
        }
        return list;
    }

    public static int dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0) return 0;
        if (i >= matrix.length || j >= matrix[0].length) return 0;
        if (visited[i][j]) return 0;
        if (matrix[i][j] == 0) return 0;
        visited[i][j] = true;
        int left = dfs(matrix, i - 1, j, visited);
        int right = dfs(matrix, i + 1, j, visited);
        int below = dfs(matrix, i, j + 1, visited);
        int above = dfs(matrix, i, j - 1, visited);
        return left + right + above + below + 1;
    }

    public static void main(String[] args) {
        int[][] rivers = new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        System.out.println(riverSizesImpl(rivers));
    }
}
