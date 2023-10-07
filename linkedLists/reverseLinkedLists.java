package linkedLists;

public class reverseLinkedLists {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        // Write your code here.
        LinkedList prevNode = null;
        LinkedList current = head;

        while (current != null) {
            LinkedList nextNode = current.next;

            current.next = prevNode;

            prevNode = current;

            current = nextNode;

        }
        return prevNode;
    }

    public static void printLinkedList(LinkedList list) {
        while (list != null) {
            System.out.print(list.value + " ");
            list = list.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(2);
        linkedListOne.next = new LinkedList(4);
        linkedListOne.next.next = new LinkedList(7);
        linkedListOne.next.next.next = new LinkedList(1);
        linkedListOne.next.next.next.next = new LinkedList(8);

        printLinkedList(reverseLinkedList(linkedListOne));
    }
}
