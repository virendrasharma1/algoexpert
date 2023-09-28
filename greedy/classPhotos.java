package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class classPhotos {

    public static boolean classPhotosImpl(List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {
        // Write your code here.
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
            first = redShirtHeights;
            second = blueShirtHeights;
        } else {
            first = blueShirtHeights;
            second = redShirtHeights;
        }
        for (int i = 0 ; i < first.size() ; i++) {
            if (second.get(i) > first.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        List<Integer> redShirtHeights = Arrays.asList(5, 8, 1, 3, 4);
        List<Integer> blueShirtHeights = Arrays.asList(6, 9, 2, 4, 5);


        System.out.println(classPhotosImpl(redShirtHeights, blueShirtHeights));
    }
}
