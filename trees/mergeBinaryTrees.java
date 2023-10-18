package trees;

import java.util.ArrayList;
import java.util.List;

public class mergeBinaryTrees {

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

    public static void mergeBinaryTreesImpl(BinaryTree tree1, BinaryTree tree2, BinaryTree parent, String leftOrRight) {
        if (tree1 != null && tree2 != null) {
            tree1.value = tree1.value + tree2.value;
            mergeBinaryTreesImpl(tree1.left, tree2.left, tree1, "L");
            mergeBinaryTreesImpl(tree1.right, tree2.right, tree1, "R");
        } else if (tree1 == null && tree2 != null) {
            if (leftOrRight.equals("L")) {
                parent.left = tree2;
            } else {
                parent.right = tree2;
            }
        }
    }

    public static BinaryTree mergeBinaryTreesImpl(BinaryTree tree1, BinaryTree tree2) {
        mergeBinaryTreesImpl(tree1, tree2, tree1, "");
        return tree1;
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
        root.left = new BinaryTree(3);
        root.right = new BinaryTree(2);
        root.left.left = new BinaryTree(7);
        root.left.right = new BinaryTree(4);

        BinaryTree root2 = new BinaryTree(1);
        root2.left = new BinaryTree(5);
        root2.right = new BinaryTree(9);
        root2.left.left = new BinaryTree(2);
        root2.right.left = new BinaryTree(7);
        root2.right.right = new BinaryTree(6);

        System.out.println(inOrderTraverse(mergeBinaryTreesImpl(root, root2), new ArrayList<>()));
    }
}
