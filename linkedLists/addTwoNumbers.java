package linkedLists;

public class addTwoNumbers {

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static ListNode addTwoNumbersImpl(ListNode firstList, ListNode secondList) {
        ListNode temp = new ListNode(0);
        ListNode newList = temp;

        int carry = 0;
        while (firstList != null && secondList != null) {
            int value = firstList.data + secondList.data + carry;
            if (value > 9) {
                carry = 1;
                newList.next = new ListNode(value % 10);
            } else {
                carry = 0;
                newList.next = new ListNode(value);
            }
            firstList = firstList.next;
            secondList = secondList.next;
            newList = newList.next;
        }
        if(firstList != null) {
            while(firstList!= null) {
                int value = firstList.data + carry;
                if (value > 9) {
                    carry = 1;
                    newList.next = new ListNode(value % 10);
                } else {
                    carry = 0;
                    newList.next = new ListNode(value);
                }
                firstList = firstList.next;
                newList = newList.next;
            }
        }
        if(secondList != null) {
            while(secondList != null) {
                int value = secondList.data + carry;
                if (value > 9) {
                    carry = 1;
                    newList.next = new ListNode(value % 10);
                } else {
                    carry = 0;
                    newList.next = new ListNode(value);
                }
                newList = newList.next;
                secondList = secondList.next;
            }
        }
        if(carry==1) {
            newList.next = new ListNode(1);
        }
        return temp.next;
    }

    public static void printLinkedList(ListNode list) {
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);

        ListNode node2 = new ListNode(3);
//        node2.next = new ListNode(3);
//        node2.next.next = new ListNode(6);

        printLinkedList(addTwoNumbersImpl(node1, node2));
    }
}
