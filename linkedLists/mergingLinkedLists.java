package linkedLists;

public class mergingLinkedLists {

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

    public static LinkedList mergingLinkedListsImpl(LinkedList linkedListOne, LinkedList linkedListTwo) {
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

        if (listOneLength == listTwoLength) {
            return mergeLinkedList(linkedListOne, linkedListTwo, listOneLength, listTwoLength, true);
        } else if (listOneLength > listTwoLength) {
            return mergeLinkedList(linkedListOne, linkedListTwo, listOneLength, listTwoLength, false);
        } else {
            return mergeLinkedList(linkedListTwo, linkedListOne, listTwoLength, listOneLength, false);
        }
    }

    private static LinkedList mergeLinkedList(LinkedList linkedListOne, LinkedList linkedListTwo, int listOneLength, int listTwoLength, boolean isEqual) {

        if (isEqual) {
            while (linkedListOne != null) {
                if (linkedListOne.value == linkedListTwo.value) {
                    break;
                }
                linkedListOne = linkedListOne.next;
                linkedListTwo = linkedListTwo.next;
            }
        } else {
            int length = listOneLength - listTwoLength;
            while (length > 0) {
                linkedListOne = linkedListOne.next;
                length--;
            }

            while (linkedListOne != null && linkedListOne.value != linkedListTwo.value) {
                linkedListOne = linkedListOne.next;
                linkedListTwo = linkedListTwo.next;
            }
        }

        return linkedListOne;
    }

    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(1);
//        linkedListOne.next = new LinkedList(2);
//        linkedListOne.next.next = new LinkedList(3);
//        linkedListOne.next.next.next = new LinkedList(4);

        LinkedList linkedListTwo = new LinkedList(2);
        linkedListTwo.next = new LinkedList(3);
        linkedListTwo.next.next = new LinkedList(4);
//        linkedListTwo.next.next.next = new LinkedList(1);
        printLinkedList(mergingLinkedListsImpl(linkedListOne, linkedListTwo));
    }
}
