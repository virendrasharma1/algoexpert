package trees;

import java.util.*;

class topView {

    static class Node {
        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static int[] topViewImpl(Node root) {

        Map<Integer, Pair> map = new TreeMap<>();
        topViewImpl(root, 0, map, 0);


        int[] returnArray = new int[map.values().size()];
        int i = 0;
        for (Pair pair : map.values()) {
            returnArray[i] = pair.node.data;
            i++;
        }

        return returnArray;
    }

    static int[] bottomViewImpl(Node root) {

        Map<Integer, Pair> map = new TreeMap<>();
        bottomViewImpl(root, 0, map, 0);
        int[] returnArray = new int[map.values().size()];
        int i = 0;
        for (Pair pair : map.values()) {
            returnArray[i] = pair.node.data;
            i++;
        }

        return returnArray;
    }

    static void bottomViewImpl(Node root, int level, Map<Integer, Pair> map, int horizontalLevel) {

        if (root == null) return;

        if (!map.containsKey(horizontalLevel) || level >= map.get(horizontalLevel).level) {
            map.put(horizontalLevel, new Pair(root, level));
        }

        bottomViewImpl(root.left, level + 1, map, horizontalLevel - 1);
        bottomViewImpl(root.right, level + 1, map, horizontalLevel + 1);
    }

    static void topViewImpl(Node root, int level, Map<Integer, Pair> map, int horizontalLevel) {

        if (root == null) return;

        if (!map.containsKey(horizontalLevel) || level < map.get(horizontalLevel).level) {
            map.put(horizontalLevel, new Pair(root, level));
        }

        topViewImpl(root.left, level + 1, map, horizontalLevel - 1);
        topViewImpl(root.right, level + 1, map, horizontalLevel + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.left = new Node(4);
        System.out.println(Arrays.toString(bottomViewImpl(root)));
    }

}