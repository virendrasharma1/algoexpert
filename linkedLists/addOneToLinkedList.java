package linkedLists;

import java.util.List;

public class addOneToLinkedList {

    static class ListNode {
        ListNode next;
        int data;

        ListNode(int data) {
            this.data = data;
        }
    }

    static ListNode addOneToList(ListNode head) {
        ListNode list = reverseLinkedList(head);
        ListNode current = list;
        ListNode prev = null;

        int carry = 1;

        while (current != null) {
            int valueInsert = current.data + carry;
            if (valueInsert > 9) {
                valueInsert = valueInsert % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            current.data = valueInsert;
            prev = current;
            current = current.next;
        }
        if (carry == 1) {
            prev.next = new ListNode(1);
        }


        return reverseLinkedList(list);
    }

    static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;

        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void printLinkedList(ListNode list) {
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        printLinkedList(addOneToList(head));
    }
}
