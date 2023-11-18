package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class rottingApples {

    static int getDaysToRot(int[][] grid) {
        int level = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        if (queue.isEmpty()) return 0;
        while (!queue.isEmpty()) {
            int[] apple = queue.poll();

            int row = apple[0];
            int column = apple[1];
            level = apple[2];


            if (row + 1 < grid.length && grid[row + 1][column] == 1) {
                grid[row + 1][column] = 2;
                queue.add(new int[]{row + 1, column, level + 1});
            }
            if (row - 1 >= 0 && grid[row - 1][column] == 1) {
                grid[row - 1][column] = 2;
                queue.add(new int[]{row - 1, column, level + 1});
            }
            if (column + 1 < grid[0].length && grid[row][column + 1] == 1) {
                grid[row][column + 1] = 2;
                queue.add(new int[]{row, column + 1, level + 1});
            }
            if (column - 1 >= 0 && grid[row][column - 1] == 1) {
                grid[row][column - 1] = 2;
                queue.add(new int[]{row, column - 1, level + 1});
            }

        }

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return -1; // There are still fresh apples left
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(getDaysToRot(grid));
    }
}
