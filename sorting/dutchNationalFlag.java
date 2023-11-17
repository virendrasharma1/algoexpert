package sorting;

import java.util.Arrays;

public class dutchNationalFlag {

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    static void sortTheArray (int[] A) {

        int low = 0;
        int mid = 0;
        int high = A.length-1;

        while(mid <= high) {
            if(A[mid] ==0) {
                swap(A, low, mid);
                low++;
                mid++;
            } else if(A[mid] == 1) {
                mid++;
            } else {
                swap(A, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,0,1,1,2,1,0,2};
        System.out.println(Arrays.toString(array));
        sortTheArray(array);
        System.out.println(Arrays.toString(array));
    }
}
