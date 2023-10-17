package trees;

/*
Time - O(n) as each node is visited once
Space - O(h) where h is height as recursive calls happen for the height and call stack contains call stack. Worst case is O(n) if it is skewed
 */
public class symmetricalTree {

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
    public static boolean symmetricalTreeImpl(BinaryTree tree) {
        return symmetricalTreeImpl(tree.left, tree.right);
    }

    public static boolean symmetricalTreeImpl(BinaryTree leftTree, BinaryTree rightTree) {
        if (leftTree == null && rightTree == null) return true;
        if (leftTree != null && rightTree == null) return false;
        if (leftTree == null) return false;
        if (leftTree.value == rightTree.value) {
            return symmetricalTreeImpl(leftTree.left, rightTree.right) && symmetricalTreeImpl(leftTree.right, rightTree.left);
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(2);
        root.left.left = new BinaryTree(3);
        root.left.right = new BinaryTree(4);
        root.right.left = new BinaryTree(4);
        root.right.right = new BinaryTree(3);
        root.left.right.left = new BinaryTree(5);
        root.right.left.right = new BinaryTree(5);
        root.right.left.right.right = new BinaryTree(5);
        System.out.println(symmetricalTreeImpl(root));
    }
}
