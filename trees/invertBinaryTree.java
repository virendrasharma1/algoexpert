package trees;

import binarySearchTree.BSTTraversal;

import java.util.ArrayList;
import java.util.List;

public class invertBinaryTree {
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

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) return;
        BinaryTree left = tree.left;
        BinaryTree right = tree.right;

        tree.left = right;
        tree.right = left;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    public static List<Integer> inOrderTraverse(BinaryTree tree, List<Integer> array) {
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
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right.left = new BinaryTree(10);
        System.out.println(inOrderTraverse(root, new ArrayList<>()));
        invertBinaryTree(root);
        System.out.println(inOrderTraverse(root, new ArrayList<>()));
    }
}
