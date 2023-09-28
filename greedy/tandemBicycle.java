package greedy;

import java.util.Arrays;

public class tandemBicycle {

    public static int tandemBicycleImpl(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int value = 0;
        int length = blueShirtSpeeds.length - 1;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            if (fastest) {
                value += Math.max(redShirtSpeeds[i], blueShirtSpeeds[length]);
                length--;
            } else {
                value += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[] redShirtSpeeds = new int[]{5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[]{3, 6, 7, 2, 1};
        System.out.println(tandemBicycleImpl(redShirtSpeeds, blueShirtSpeeds, true));
    }
}
