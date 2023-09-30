package binarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class minHeightBST {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        int max = array.size() - 1;
        int min = 0;
        return minHeightBST(array, min, max);
    }

    public static BST minHeightBST(List<Integer> array, int min, int max) {
        if (min > max) return null;
        int midHeight = (min + max) / 2;
        BST tree = new BST(array.get(midHeight));
        tree.left = minHeightBST(array, min, midHeight - 1);
        tree.right = minHeightBST(array, midHeight + 1, max);
        return tree;
    }

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        BST res = minHeightBst(array);
        System.out.println(inOrderTraverse(res, new ArrayList<>()));
    }
}
