package binarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTTraversal {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
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

    public static List<Integer> inOrderTraverseIterative(BST tree, List<Integer> array) {
        Stack<BST> stack = new Stack<>();
        BST current = tree;

        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            array.add(current.value);
            current = current.right;
        }
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        array.add(tree.value);

        if (tree.left != null) {
            preOrderTraverse(tree.left, array);
        }
        if (tree.right != null) {
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> preOrderTraverseIterative(BST tree, List<Integer> array) {
        Stack<BST> stack = new Stack<>();
        stack.push(tree);

        while (!stack.empty()) {
            BST current = stack.pop();
            if (current != null) {
                array.add(current.value);
                stack.push(current.left);
                stack.push(current.right);
            }
        }
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            postOrderTraverse(tree.left, array);
        }
        if (tree.right != null) {
            postOrderTraverse(tree.right, array);
        }
        array.add(tree.value);

        return array;
    }


    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.left = new BST(5);
        bst.left.left = new BST(2);
        bst.left.left.left = new BST(1);
        bst.left.right = new BST(5);


        bst.right = new BST(15);
        bst.right.right = new BST(22);


        System.out.println(inOrderTraverse(bst, new ArrayList<>()));
        System.out.println(inOrderTraverseIterative(bst, new ArrayList<>()));
        System.out.println(preOrderTraverse(bst, new ArrayList<>()));
        System.out.println(postOrderTraverse(bst, new ArrayList<>()));
    }
}
