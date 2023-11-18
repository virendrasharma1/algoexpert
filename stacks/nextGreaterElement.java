package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class nextGreaterElement {

    static int[] getNextGreaterElement(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                A[stack.pop()] = A[i];
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            A[stack.pop()] = -1;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNextGreaterElement(new int[]{1, 5, 2, 3, 5})));
    }
}
