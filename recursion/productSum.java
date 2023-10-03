package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class productSum {

    public static int productSumImpl(List<Object> array) {
        return productSumHelper(array, 1);
    }

    public static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object o : array) {
            if (o instanceof ArrayList<?>) {
                ArrayList<Object> objectList = (ArrayList<Object>) o;
                sum += productSumHelper(objectList , multiplier + 1);
            } else {
                sum += (int) o;
            }
        }
        return sum * multiplier;
    }

    public static void main(String[] args) {
//        [5, 2, [7, -1]]

        List<Object> list = new ArrayList<>();
        list.add(5);
        list.add(2);

        List<Object> nested = new ArrayList<Object>();
        nested.add(7);
        nested.add(-1);
        list.add(nested);

        System.out.println(productSumImpl(list));
    }
}
