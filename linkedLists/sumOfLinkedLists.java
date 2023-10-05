package linkedLists;

public class sumOfLinkedLists {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void printLinkedList(LinkedList list) {
        while (list != null) {
            System.out.print(list.value + " ");
            list = list.next;
        }
    }

    public static LinkedList sumOfLinkedListsImpl(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        int listOneLength = 0;
        int listTwoLength = 0;
        LinkedList temp = linkedListOne;
        while (temp != null) {
            listOneLength++;
            temp = temp.next;
        }

        LinkedList temp2 = linkedListTwo;
        while (temp2 != null) {
            listTwoLength++;
            temp2 = temp2.next;
        }

        if (listOneLength >= listTwoLength) {
            return getLinkedList(linkedListOne, linkedListTwo);
        } else {
            return getLinkedList(linkedListTwo, linkedListOne);
        }
    }

    public static LinkedList getLinkedList(LinkedList linkedListOne, LinkedList linkedListTwo) {
        int carry = 0;
        LinkedList temp = new LinkedList(0);
        LinkedList res = temp;
        while (linkedListOne != null) {
            int valueInsert = linkedListOne.value + (linkedListTwo != null ? linkedListTwo.value : 0) + carry;
            if (valueInsert > 9) {
                valueInsert = valueInsert % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            temp.next = new LinkedList(valueInsert);
            temp = temp.next;
            linkedListOne = linkedListOne.next;
            if (linkedListTwo != null) {
                linkedListTwo = linkedListTwo.next;
            }
        }
        if (carry == 1) {
            temp.next = new LinkedList(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(2);
//        linkedListOne.next = new LinkedList(4);
//        linkedListOne.next.next = new LinkedList(7);
//        linkedListOne.next.next.next = new LinkedList(1);

        LinkedList linkedListTwo = new LinkedList(9);
//        linkedListTwo.next = new LinkedList(4);
//        linkedListTwo.next.next = new LinkedList(5);
        printLinkedList(sumOfLinkedListsImpl(linkedListOne, linkedListTwo));
    }
}
