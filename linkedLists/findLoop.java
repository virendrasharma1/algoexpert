package linkedLists;

public class findLoop {

    static class LinkedList {
        public int value;
        public LinkedList next;

        LinkedList(int value) {
            this.value = value;
        }
    }

    public static LinkedList findLoopImpl(LinkedList head) {

        LinkedList slow = head.next;
        LinkedList fast = head.next.next;

        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    public static LinkedList removeNode(LinkedList head) {

        LinkedList slow = head.next;
        LinkedList fast = head.next.next;

        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        LinkedList prev = null;

        while (head != slow) {
            prev = slow;
            head = head.next;
            slow = slow.next;
        }
        prev.next = null;
        return head;
    }

    public static void printLinkedList(LinkedList list) {
        while (list != null) {
            System.out.print(list.value + " ");
            list = list.next;
        }
    }
    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(0);
        linkedListOne.next = new LinkedList(1);
        linkedListOne.next.next = new LinkedList(2);
        linkedListOne.next.next.next = new LinkedList(3);
        LinkedList linkedListFour = new LinkedList(4);

        linkedListOne.next.next.next.next = linkedListFour;
        linkedListOne.next.next.next.next.next = new LinkedList(5);
        linkedListOne.next.next.next.next.next.next = new LinkedList(6);
        linkedListOne.next.next.next.next.next.next.next = new LinkedList(7);
        linkedListOne.next.next.next.next.next.next.next.next = new LinkedList(8);
        linkedListOne.next.next.next.next.next.next.next.next.next = new LinkedList(9);
        linkedListOne.next.next.next.next.next.next.next.next.next.next = linkedListFour;


        printLinkedList(removeNode(linkedListOne));
    }
}
