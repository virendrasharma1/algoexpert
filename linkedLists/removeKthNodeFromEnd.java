package linkedLists;

public class removeKthNodeFromEnd {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void removeKthNodeFromEndImpl(LinkedList head, int k) {
        int count = 0;
        LinkedList first = head;
        LinkedList second = head;

        while (count < k) {
            first = first.next;
            count++;
        }
        if (first == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        while (first.next != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        printLinkedList(head);
    }

    public static void remove(LinkedList list) {
        // Write your code here.
    }

    public static void printLinkedList(LinkedList list) {
        while (list != null) {
            System.out.print(list.value + " ");
            list = list.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.next = new LinkedList(2);
        linkedList.next.next = new LinkedList(3);
        linkedList.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next = new LinkedList(5);
        linkedList.next.next.next.next.next = new LinkedList(6);
        linkedList.next.next.next.next.next.next = new LinkedList(7);
        linkedList.next.next.next.next.next.next.next = new LinkedList(8);
        linkedList.next.next.next.next.next.next.next.next = new LinkedList(9);
        removeKthNodeFromEndImpl(linkedList, 5);
    }
}
