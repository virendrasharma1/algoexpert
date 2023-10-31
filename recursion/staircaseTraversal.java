package recursion;

public class staircaseTraversal {
    /*
    Time complexity - O(maxSteps^height)
     */
    public static int staircaseTraversalImpl(int height, int maxSteps) {
        if (height<0) return 0;

        if (height==0) return 1;
        if (height==1) return 1;
        int value = 0;
        for (int i = 1; i <= maxSteps; i++) {
            value += staircaseTraversalImpl(height-i, maxSteps);
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(staircaseTraversalImpl(4, 3));
    }
}
