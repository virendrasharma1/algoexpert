package sorting;

import java.util.Arrays;

public class insertionSort {

    public static void insertionSortImpl(int[] array) {
        for (int i = 1 ; i < array.length ; i++) {
            int key = array[i];
            int iStartvalue = i;

            int j = i-1;

            while( j >=0 && array[j] > key) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i--;
                j--;
            }
            i = iStartvalue;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{29, 28, 7, 91, 2, 3};
        System.out.println(Arrays.toString(array));
        insertionSortImpl(array);
        System.out.println(Arrays.toString(array));
}

//2 4 1 5 8 3

//i = 4;
//j = 2;

// i= 1
// j = 4

//while(j >= 0 && j > i) {
//    swap()
//    j--;
//    i--;
}