package binarySearchTree;

public class validateBST {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBSTWithMaxMin(tree, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean validateBSTWithMaxMin(BST tree, int max, int min) {
        if (max > tree.value && min <= tree.value) {
            if (tree.left != null) {
                if (!validateBSTWithMaxMin(tree.left, tree.value, min)) {
                    return false;
                }
            }

            if (tree.right != null) {
                if (!validateBSTWithMaxMin(tree.right, max, tree.value)) {
                    return false;
                }
            }
                return true;
        } else {
            return false;
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


        System.out.println(validateBst(bst));
    }
}
