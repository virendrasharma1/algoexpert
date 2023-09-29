package binarySearchTree;

public class findClosestValueInBst {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBstImplIterative(BST tree, int target) {
        // Write your code here.
        int difference = Math.abs(target - tree.value);
        int closestValue = tree.value;

        BST currentTree = tree;
        while (currentTree != null) {
            if (difference > Math.abs(target - currentTree.value)) {
                closestValue = currentTree.value;
                difference = Math.abs(target - currentTree.value);
            }
            if (target > currentTree.value) {
                currentTree = currentTree.right;
            } else {
                currentTree = currentTree.left;
            }
        }

        return closestValue;
    }

    public static int findClosestValueInBstRecursive(BST tree, int target) {
        // Write your code here.
        return findClosestValueInBstRecursive(tree, target, tree.value);

    }

    public static int findClosestValueInBstRecursive(BST tree, int target, int closestValue) {
        if (Math.abs(target - closestValue) > Math.abs(target - tree.value)) {
            closestValue = tree.value;
        }

        if (target > tree.value && tree.right != null) {
            return findClosestValueInBstRecursive(tree.right, target, closestValue);
        } else if (target < tree.value && tree.left != null) {
            return findClosestValueInBstRecursive(tree.left, target, closestValue);
        } else {
            return closestValue;
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


        System.out.println(findClosestValueInBstRecursive(bst, 12));
    }
}
