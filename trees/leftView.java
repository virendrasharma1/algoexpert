package trees;

import java.util.*;

public class leftView {

    static class Node {
        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }
    static int[] leftView(Node root) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> levelSet = new HashSet<>();

        leftView(root, list, 0, levelSet);
        return list.stream().mapToInt(a -> (int) a).toArray();
    }

    static void leftView (Node root, List<Integer> list, int level, Set<Integer> levelSet) {

        if (root == null) return;
        if(!levelSet.contains(level)) {
            list.add(root.data);
        }
        levelSet.add(level);

        leftView(root.left, list, level + 1, levelSet);
        leftView(root.right, list, level + 1, levelSet);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.left.left = new Node(8);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.left = new Node(4);
        System.out.println(Arrays.toString(leftView(root)));
    }
}
