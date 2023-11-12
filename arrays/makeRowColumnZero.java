package arrays;

import java.util.*;

class makeRowColumnZero {
    static void setRowColumnZeroes(int[][] matrix) {
        List<int[]> indexList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    indexList.add(new int[]{i, j});
                }
            }
        }
        List<Integer> l = new ArrayList<>();
        makeRowColumnZeroHelper(matrix, indexList, matrix.length, matrix[0].length);
    }

    static void makeRowColumnZeroHelper(int[][] matrix, List<int[]> indexList, int rowSize, int columnSize) {
        for (int[] coordinate : indexList) {
            int row = coordinate[0];
            int column = coordinate[1];
            for (int i = 0; i < rowSize; i++) {
                matrix[i][column] = 0;
            }
            for (int i = 0; i < columnSize; i++) {
                System.out.println(i);
                System.out.println(row);
                matrix[row][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] rivers = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println(Arrays.deepToString(rivers));
        setRowColumnZeroes(rivers);
        System.out.println(Arrays.deepToString(rivers));
    }
}