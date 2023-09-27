package graphs;

import java.util.ArrayList;
import java.util.List;

public class depthFirstSearch {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            array.add(this.name);

            for (Node child: children) {
                child.depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        Node nodeG = new Node("G");
        Node nodeH = new Node("H");

        Node nodeI = new Node("I");
        Node nodeJ = new Node("J");

        Node nodeK = new Node("K");

        List<Node> listA = new ArrayList<>();
        listA.add(nodeB);
        listA.add(nodeC);
        listA.add(nodeD);
        nodeA.children = listA;

        List<Node> listB = new ArrayList<>();
        listB.add(nodeE);
        listB.add(nodeF);
        nodeB.children = listB;

        List<Node> listF = new ArrayList<>();
        listF.add(nodeI);
        listF.add(nodeJ);
        nodeF.children = listF;

        List<Node> listD = new ArrayList<>();
        listD.add(nodeG);
        listD.add(nodeH);
        nodeD.children = listD;

        List<Node> listG = new ArrayList<>();
        listG.add(nodeK);
        nodeG.children = listG;

        List<String> result = nodeA.depthFirstSearch(new ArrayList<>());

        System.out.println(result);

    }
}
