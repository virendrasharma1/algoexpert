package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class reconstructBst {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST reconstructBstImpl(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.isEmpty()) return null;
        int arrayValue = preOrderTraversalValues.get(0);
        BST bst = new BST(arrayValue);
        int largestIndex = getLargestIndex(arrayValue, preOrderTraversalValues);

        bst.left = reconstructBstImpl(preOrderTraversalValues.subList(1, largestIndex));

        bst.right = reconstructBstImpl(preOrderTraversalValues.subList(largestIndex, preOrderTraversalValues.size()));
        return bst;
    }

    public static int getLargestIndex(int arrayValue, List<Integer> array) {
        int counter = array.size();

        for (int i = 1; i < array.size(); i++) {
            int value = array.get(i);
            if (value >= arrayValue) {
                counter = i;
                break;
            }
        }
        return counter;
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
        List<Integer> preOrderTraversalValues = new ArrayList<>(List.of(10, 4, 2, 1, 5, 17, 19, 18));
        System.out.println(inOrderTraverse(reconstructBstImpl(preOrderTraversalValues), new ArrayList<>()));
    }
}
