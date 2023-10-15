package trees;

/*
Time complexity is O(n) as each node is visited once hence n nodes
Space is O(h) where h is the height of tree as recursion calls take stack value. Worst case will be O(n) as height equals, best case O(logn) if it is balanced
 */
public class nodeDepths {
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

    public static int nodeDepthsImpl(BinaryTree root) {
        SumInfo sumInfo = new SumInfo(0);
        return nodeDepthsImpl(root, sumInfo, -1);
    }

    public static class SumInfo {
        private int sum;

        SumInfo(int sum) {
            this.sum = sum;
        }
    }

    public static int nodeDepthsImpl(BinaryTree root, SumInfo sumInfo, int depth) {
        depth += 1;
        if (root.left != null) {
            nodeDepthsImpl(root.left, sumInfo, depth);
        }

        if (root.right != null) {
            nodeDepthsImpl(root.right, sumInfo, depth);
        }

        sumInfo.sum = sumInfo.sum + depth;
        return sumInfo.sum;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);

        binaryTree.left = new BinaryTree(2);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.left.left = new BinaryTree(8);
        binaryTree.left.left.right = new BinaryTree(9);
        binaryTree.left.right = new BinaryTree(5);

        binaryTree.right = new BinaryTree(3);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);
        System.out.println(nodeDepthsImpl(binaryTree));
    }
}
