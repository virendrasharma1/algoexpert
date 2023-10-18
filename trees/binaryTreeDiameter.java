package trees;

public class binaryTreeDiameter {
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

    static class TreeInfo {
        private int maxValue;

        TreeInfo(int maxValue) {
            this.maxValue = maxValue;
        }
    }

    public static int binaryTreeDiameter(BinaryTree tree) {
        TreeInfo info = new TreeInfo(0);
        binaryTreeDiameter(tree, info);
        return info.maxValue;
    }

    public static int binaryTreeDiameter(BinaryTree tree, TreeInfo info) {
        if (tree.right == null && tree.left == null) return 0;
        int left = 0;
        int right = 0;
        if (tree.left != null) {
            left = binaryTreeDiameter(tree.left, info) + 1;
        }

        if (tree.right != null) {
            right = binaryTreeDiameter(tree.right, info) + 1;
        }

        if (left + right > info.maxValue) {
            info.maxValue = left + right;
        }
        return Math.max(left, right);

    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(3);
        root.right = new BinaryTree(2);
        root.left.left = new BinaryTree(7);
        root.left.right = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.left.left = new BinaryTree(9);
        root.left.right.right = new BinaryTree(5);
        root.left.right.right.right = new BinaryTree(6);
        System.out.println(binaryTreeDiameter(root));
    }
}
