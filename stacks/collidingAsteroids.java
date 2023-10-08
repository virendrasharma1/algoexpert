package stacks;

import java.util.Arrays;
import java.util.Stack;

public class collidingAsteroids {

    public static int[] collidingAsteroidsImpl(int[] asteroids) {
        // Write your code here.

        Stack<Integer> stack = new Stack<>();

        for (int value : asteroids) {
            if (stack.isEmpty() || value > 0 || stack.peek() < 0) {
                stack.add(value);
                continue;
            }

            while (!stack.isEmpty()) {

                if (stack.peek() < 0) {
                    stack.add(value);
                    break;
                }
                if (stack.peek() > Math.abs(value)) {
                    break;
                }

                if (stack.peek() == Math.abs(value)) {
                    stack.pop();
                    break;
                }
                stack.pop();

                if (stack.isEmpty()) {
                    stack.add(value);
                    break;
                }
            }
        }
        return stack.stream().mapToInt(val -> (int) val).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(collidingAsteroidsImpl(new int[]{-3, 5, -8, 6, 7, -4, -7})));
    }
}
