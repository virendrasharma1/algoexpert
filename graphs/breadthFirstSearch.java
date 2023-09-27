package graphs;

import java.util.*;

/*
Note -
Why didn't we use priority Queue but LinkedList

LinkedList preserves the insertion order, PriorityQueue does not.
So your iteration order changes, which makes your implementation that uses PriorityQueue something other than BFS.

And priority queue
An unbounded priority queue based on a priority heap.
The elements of the priority queue are ordered according to their natural ordering,
or by a Comparator provided at queue construction time, depending on which constructor is used.
A priority queue does not permit null elements.
A priority queue relying on natural ordering also does not permit insertion of non-comparable objects
(doing so may result in ClassCastException).


 */

public class breadthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
            Queue<Node> stringQueue = new LinkedList<>();

            stringQueue.add(this);

            while (!stringQueue.isEmpty()) {
                Node currentNode = stringQueue.poll();
                array.add(currentNode.name);
                stringQueue.addAll(currentNode.children);
            }
            return array;
        }

        public Queue<String> addIntoQueue(Queue<String> queue) {
            queue.add(this.name);

            for (Node child : children) {
                queue = child.addIntoQueue(queue);
            }
            return queue;
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

        List<String> result = nodeA.breadthFirstSearch(new ArrayList<>());

        System.out.println(result);

    }
}
