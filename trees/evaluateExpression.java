package trees;

import java.util.ArrayList;
import java.util.List;

public class evaluateExpression {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static int evaluateExpressionTree(BinaryTree tree) {
        // Write your code here.
        if (tree.value >= 0) {
            return tree.value;
        }
        int leftValue = evaluateExpressionTree(tree.left);
        int rightValue = evaluateExpressionTree(tree.right);

        if (tree.value == -4) {
            return leftValue * rightValue;
        } else if (tree.value == -1) {
            return leftValue + rightValue;
        } else if (tree.value == -2) {
            return leftValue - rightValue;
        }
        return leftValue / rightValue;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);

        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(4);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.left.right = new BinaryTree(5);
        tree.left.right.left = new BinaryTree(10);

        tree.right = new BinaryTree(3);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        System.out.println(evaluateExpressionTree(tree));
    }
}
