package graphs;

import java.util.Arrays;

public class removeIslands {
    public static int[][] removeIslandsImpl(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, i, 0);
            dfs(matrix, i, matrix[0].length - 1);
            dfs(matrix, 0, i);
            dfs(matrix, matrix.length - 1, i);
        }
        transformMatrix(matrix);
        return matrix;
    }

    public static void transformMatrix(int[][] matrix) {
        for (int i = 0 ; i <matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] == 2 ? 1 : 0;
            }
        }
    }

    public static void dfs(int[][] matrix, int row, int column) {

        if (row < 0 || column < 0) return;
        if (row >= matrix.length || column >= matrix[0].length) return;


        if (matrix[row][column] != 1) return;

        matrix[row][column] = 2;
        dfs(matrix, row - 1, column);
        dfs(matrix, row + 1, column);
        dfs(matrix, row, column - 1);
        dfs(matrix, row, column + 1);
    }

    public static void main(String[] args) {
        int[][] rivers = new int[][]{
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };
        System.out.println(Arrays.deepToString(removeIslandsImpl(rivers)));
    }
}
