package binarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class findKthLargestValueInBST {

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


    static class TreeInfo {
        public int activeNodeValue;
        public int numberOfNodesScanned;

        public TreeInfo(int activeNodeValue, int numberOfNodesScanned) {
            this.activeNodeValue = activeNodeValue;
            this.numberOfNodesScanned = numberOfNodesScanned;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        TreeInfo info = new TreeInfo(tree.value, 0);
        inOrderTraverseReverse(tree, info, k);
        return info.activeNodeValue;
    }

    public void inOrderTraverseReverse(BST tree, TreeInfo info, int k) {
        if (tree == null || info.numberOfNodesScanned >=k) {
            return;
        }
        inOrderTraverseReverse(tree.right, info, k);
        if (info.numberOfNodesScanned < k) {
            info.activeNodeValue = tree.value;
            info.numberOfNodesScanned += 1;
            inOrderTraverseReverse(tree.left, info, k);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.left = new BST(5);
        bst.left.left = new BST(2);
        bst.left.left.left = new BST(1);
        bst.left.right = new BST(5);


        bst.right = new BST(15);
        bst.right.right = new BST(22);
        bst.right.left = new BST(13);
        bst.right.left.right = new BST(14);

        findKthLargestValueInBST find = new findKthLargestValueInBST();
        System.out.println(find.findKthLargestValueInBst(bst, 3));
    }
}
