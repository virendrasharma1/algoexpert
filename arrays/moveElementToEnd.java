package arrays;

import java.util.ArrayList;
import java.util.List;

public class moveElementToEnd {

    public static List<Integer> moveElementToEndImpl(ArrayList<Integer> array, int toMove) {

        int start = 0;
        int end = array.size() - 1;

        while (end > start) {
            if (array.get(start).equals(toMove) && !array.get(end).equals(toMove)) {
                int temp = array.get(end);
                array.set(start, temp);
                array.set(end, toMove);
                end--;
            }

            if (array.get(start) != toMove) {
                start++;
            }

            if (array.get(end) == toMove) {
                end--;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(moveElementToEndImpl(new ArrayList<>(List.of(2, 1, 2, 2, 2, 3, 4, 2)), 2));
    }
}
