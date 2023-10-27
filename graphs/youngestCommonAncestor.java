package graphs;

import linkedLists.mergingLinkedLists;

import java.lang.reflect.AccessibleObject;
import java.util.*;

/*
Space complexity - O(1) as only one variable is getting declared
Time - O(n) where n is the height of tree
 */
public class youngestCommonAncestor {

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        return getFirstCommonFromLinkedList(descendantOne, descendantTwo);

    }

    private static AncestralTree getFirstCommonFromLinkedList(AncestralTree linkedListOne, AncestralTree linkedListTwo) {
        AncestralTree newTree = linkedListOne;
        AncestralTree newTree2 = linkedListTwo;

        int firstTreeLength = 0;
        int secondTreeLength = 0;
        while (newTree != null) {
            firstTreeLength++;
            newTree = newTree.ancestor;
        }

        while (newTree2 != null) {
            secondTreeLength++;
            newTree2 = newTree2.ancestor;
        }
        int minusLength = Math.abs(firstTreeLength - secondTreeLength);

        AncestralTree biggerTree = firstTreeLength > secondTreeLength ? linkedListOne : linkedListTwo;
        AncestralTree smallerTree = firstTreeLength <= secondTreeLength ? linkedListOne : linkedListTwo;

        while (minusLength > 0) {
            biggerTree = biggerTree.ancestor;
            minusLength--;
        }

        while (biggerTree != smallerTree) {
            biggerTree = biggerTree.ancestor;
            smallerTree = smallerTree.ancestor;
        }

        return biggerTree;
    }

    private static Queue<AncestralTree> getQueueFromDescendent(AncestralTree topAncestor, AncestralTree descendant) {
        Queue<AncestralTree> queue = new LinkedList<>();

        return getQueueFromDescendent(topAncestor, descendant, queue);
    }

    private static Queue<AncestralTree> getQueueFromDescendent(AncestralTree topAncestor, AncestralTree descendant, Queue<AncestralTree> queue) {
        queue.add(descendant);
        return queue;
    }

    public static void main(String[] args) {
        AncestralTree nodeA = new AncestralTree('A');

        AncestralTree nodeB = new AncestralTree('B');
        AncestralTree nodeC = new AncestralTree('C');

        AncestralTree nodeD = new AncestralTree('D');
        AncestralTree nodeE = new AncestralTree('E');

        AncestralTree nodeF = new AncestralTree('F');
        AncestralTree nodeG = new AncestralTree('G');

        AncestralTree nodeH = new AncestralTree('H');
        AncestralTree nodeI = new AncestralTree('I');


        AncestralTree[] listA = new AncestralTree[2];
        listA[0] = nodeB;
        listA[1] = nodeC;
        nodeA.addAsAncestor(listA);

        AncestralTree[] listB = new AncestralTree[2];
        listB[0] = nodeD;
        listB[1] = nodeE;
        nodeB.addAsAncestor(listB);

        AncestralTree[] listD = new AncestralTree[2];
        listD[0] = nodeH;
        listD[1] = nodeI;
        nodeD.addAsAncestor(listD);

        AncestralTree[] listC = new AncestralTree[2];
        listC[0] = nodeF;
        listC[1] = nodeG;
        nodeC.addAsAncestor(listC);

        getYoungestCommonAncestor(nodeA, nodeE, nodeI);

    }
}
