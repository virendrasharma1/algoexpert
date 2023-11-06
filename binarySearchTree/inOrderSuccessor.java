package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

class inOrderSuccessor {

    static class Node {
        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Found {
        boolean found;
        Node nodeFound;

        Found(boolean found, Node nodeFound) {
            this.found = found;
            this.nodeFound = nodeFound;
        }
    }

    static Node findSuccessor(Node root, Node p) {
        Found found = new Found(false, null);
        traverse(root, p, found);
        return found.nodeFound;
    }

    static void traverse(Node root, Node p, Found found) {
        if (root == null) return;

        traverse(root.left, p, found);

        if (found.nodeFound == null && root.data > p.data) {
            found.nodeFound = root;
        } else if (found.nodeFound != null && root.data > p.data && root.data < found.nodeFound.data) {
            found.nodeFound = root;
        }
        traverse(root.right, p, found);
    }

    public static List<Integer> inOrderTraverse(Node tree, List<Integer> array) {
        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.data);
        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static void main(String[] args) {
        Node bst = new Node(10);
        bst.left = new Node(5);
        bst.left.left = new Node(2);
        bst.left.left.left = new Node(1);
        bst.left.right = new Node(5);


        bst.right = new Node(15);
        bst.right.right = new Node(22);
        bst.right.left = new Node(13);
        bst.right.left.right = new Node(14);
        System.out.println(inOrderTraverse(bst, new ArrayList<>()));

        System.out.println(inOrderTraverse(findSuccessor(bst, bst.left.left), new ArrayList<>()));
    }
}