package trees;

/*
Space complexity - O(n) where n is number of nodes since everytime it goes once
Time complexity - O(h)
 */
public class heightBalancedBinaryTree {
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

    public static boolean heightBalancedBinaryTreeImpl(BinaryTree tree) {
        // Write your code here.
        Info info = new Info(true);
        heightBalancedBinaryTreeImpl(tree, 0, info);
        return info.info;
    }

    public static class Info {
        private boolean info;

        Info(boolean info) {
            this.info = info;
        }
    }

    public static int heightBalancedBinaryTreeImpl(BinaryTree tree, int height, Info info) {

        if (tree == null) return height;
        int left = heightBalancedBinaryTreeImpl(tree.left, height + 1, info);
        int right = heightBalancedBinaryTreeImpl(tree.right, height + 1, info);
        if (Math.abs(left - right) > 1) info.info = false;
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);
        root.left.right.right.right = new BinaryTree(9);

        System.out.println(heightBalancedBinaryTreeImpl(root));
    }
}
