package trees;

import binarySearchTree.BSTTraversal;

import java.util.ArrayList;
import java.util.List;

public class preOrderAndInorderTraversal {

    static class Node {
        public Node left;
        public Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static Node constructTreeImpl(int[] preorder, int[] inorder) {
        return constructTreeImpl(preorder, 0, preorder.length - 1, inorder, 0, inorder.length-1);
    }

    static Node constructTreeImpl(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd) {

        if (preOrderStart > preOrderEnd || inOrderStart > inOrderEnd) {
            return null;
        }

        int rootValue = preOrder[preOrderStart];
        Node head = new Node(rootValue);

        int rootIndexInorder = 0;
        for (int i = inOrderStart; i <= inOrderEnd; i++) {
            if (inOrder[i] == rootValue) {
                rootIndexInorder = i;
                break;
            }
        }

        // Calculate the number of nodes in the left and right subtrees
        int leftSubtreeSize = rootIndexInorder - inOrderStart;
        int rightSubtreeSize = inOrderEnd - rootIndexInorder;

        // Recursively build left and right subtrees
        head.left = constructTreeImpl(preOrder, preOrderStart + 1, preOrderStart + leftSubtreeSize,
                inOrder, inOrderStart, rootIndexInorder - 1);
        head.right = constructTreeImpl(preOrder, preOrderEnd - rightSubtreeSize + 1, preOrderEnd,
                inOrder, rootIndexInorder + 1, inOrderEnd);

        return head;
    }

    public static List<Integer> preOrderTraverse(Node tree, List<Integer> array) {
        array.add(tree.data);

        if (tree.left != null) {
            preOrderTraverse(tree.left, array);
        }
        if (tree.right != null) {
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(preOrderTraverse(constructTreeImpl(new int[]{1, 2, 4, 5, 7, 3, 6, 8}, new int[]{4, 2, 7, 5, 1, 8, 6, 3}), new ArrayList<>()));
    }
}
