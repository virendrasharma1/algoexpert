package linkedLists;

public class middleNode {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList middleNodeImpl(LinkedList linkedList) {
        LinkedList fastNode = linkedList;
        LinkedList slowNode = linkedList;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static void printLinkedList(LinkedList list) {
        while (list != null) {
            System.out.print(list.value + " ");
            list = list.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(2);
        linkedList.next = new LinkedList(7);
        linkedList.next.next = new LinkedList(3);
        linkedList.next.next.next = new LinkedList(5);
        printLinkedList(middleNodeImpl(linkedList));
    }
}
