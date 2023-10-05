package linkedLists;

import java.util.LinkedList;

public class removeDuplicatesFromLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedListImpl(LinkedList list) {
        LinkedList current = list;
        while (current != null) {
            LinkedList nextUniqueNode = current.next;
            while (nextUniqueNode != null && nextUniqueNode.value == current.value) {
                nextUniqueNode = nextUniqueNode.next;
            }
            current.next = nextUniqueNode;
            current = nextUniqueNode;
        }
        return list;
    }

    public static void printLinkedList(LinkedList list) {
        while (list != null) {
            System.out.print(list.value + " ");
            list = list.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.next = new LinkedList(1);
        linkedList.next.next = new LinkedList(3);
        linkedList.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next.next = new LinkedList(5);
        linkedList.next.next.next.next.next.next.next = new LinkedList(6);
        linkedList.next.next.next.next.next.next.next.next = new LinkedList(6);

//        printLinkedList(linkedList);
        printLinkedList(removeDuplicatesFromLinkedListImpl(linkedList));
    }
}
