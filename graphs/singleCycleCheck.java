package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

  You're given an array of integers where each integer represents a jump of its
  value in the array. For instance, the integer <span>2</span> represents a jump
  of two indices forward in the array; the integer <span>-3</span> represents a
  jump of three indices backward in the array.

 */
public class singleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
//        getIndex(1, array);

        int numberOfCycles = 0;
        int resultIndex = 0;
        while (numberOfCycles < array.length) {
            if (numberOfCycles > 0 && resultIndex == 0) {
                return false;
            }
            resultIndex = getIndex(resultIndex, array);
            numberOfCycles++;
        }
        return resultIndex == 0;
    }

    public static int getIndex(int index, int[] array) {

        int value = array[index];

        int nextIndex = (value + index) % array.length;

        return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 11, -6, -23, -2, 3, 88, 908, -26};
        System.out.println(hasSingleCycle(array));

    }
}
