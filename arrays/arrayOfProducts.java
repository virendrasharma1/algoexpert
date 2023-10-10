package arrays;

import java.util.Arrays;

/*
Space - O(n) as we are creating new array
Time - O(n) as there are two loops and both run on O(n)
 */
public class arrayOfProducts {

    public static int[] arrayOfProductsImpl(int[] array) {

        int[] result = new int[array.length];
        int leftSideProduct = 1;
        for (int i = 0; i < array.length; i++) {
            result[i] = leftSideProduct;
            leftSideProduct = leftSideProduct * array[i];
        }
        int rightSideProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            result[i] = rightSideProduct * result[i];
            rightSideProduct = rightSideProduct * array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfProductsImpl(new int[]{5, 1, 4, 2})));
    }
}
