package arrays;

import java.util.Arrays;

public class rotateArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {4, 5},
                {7, 8}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);



        System.out.println(Arrays.deepToString(rotateMatrix(matrix)));
        printMatrix(matrix);
    }

    static int[][] rotateMatrix(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] rotatedMatrix = new int[m][n];

        // Transpose the matrix in-place
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedMatrix[j][i] = matrix[i][j];
            }
        }

        // Reverse each row in-place
        for(int i = 0; i < m; i++) {
            int start = 0, end = n - 1;
            while(start < end) {
                int temp = rotatedMatrix[i][start];
                rotatedMatrix[i][start] = rotatedMatrix[i][end];
                rotatedMatrix[i][end] = temp;
                start++;
                end--;
            }
        }
        return rotatedMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
