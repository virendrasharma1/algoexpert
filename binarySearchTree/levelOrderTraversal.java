package binarySearchTree;

import trees.leftView;

import java.util.*;

public class levelOrderTraversal {
    static class Node {
        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }
    static List<Integer> getLevelOrderTraversal(Node root) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        levelOrderTraversalHelper(root, map, 0);

        return getLevelOrder(map);
    }

    static List<Integer> bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();

        List<Integer> traversal = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            traversal.add(current.data);

            if (current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
        return traversal;
    }



    static void levelOrderTraversalHelper(Node root, Map<Integer, List<Integer>> map, int level) {

        if(root == null) return;

        if(map.containsKey(level)) {
            List<Integer> list = new ArrayList<>(map.get(level));
            list.add(root.data);
            map.put(level, new ArrayList<>(list));
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(level, list);
        }

        levelOrderTraversalHelper(root.left, map, level+1);
        levelOrderTraversalHelper(root.right, map, level+1);
    }

    static List<Integer> getLevelOrder(Map<Integer, List<Integer>> map) {
        List<Integer> list = new ArrayList<>();
        for(List<Integer> l : map.values()) {
            list.addAll(l);
        }
        return list;
    }

    public static void main(String[] args) {
        Node bst = new Node(1);

        bst.left = new Node(2);
        bst.left.right = new Node(5);
        bst.left.right.left = new Node(7);
        bst.left.left = new Node(4);

        bst.right = new Node(3);
        bst.right.left = new Node(6);
        bst.right.left.left = new Node(8);

        System.out.println(getLevelOrderTraversal(bst));
    }
}
