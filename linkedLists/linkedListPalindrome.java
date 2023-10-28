package linkedLists;

import java.util.LinkedList;
import java.util.Optional;

public class linkedListPalindrome {

    static class LinkedList {
        public int value;
        public LinkedList next;

        LinkedList(int value) {
            this.value = value;
        }
    }

    static LinkedList startLi;

    public static boolean linkedListPalindromeImpl(LinkedList head) {
        LinkedList start = head;
        startLi = head;

        return recursion(start);
    }

    public static LinkedList reverseLinkList(LinkedList list) {
        LinkedList current = list;
        LinkedList prev = null;

        while (current != null) {
            LinkedList next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static boolean linkedListPalindromeImplDifferent(LinkedList head) {
        LinkedList fast = head;
        LinkedList slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        LinkedList reversed = reverseLinkList(slow);

        return checkifEqual(head, reversed);
    }

    private static boolean checkifEqual(LinkedList head, LinkedList reversed) {
        while (reversed != null) {
            if (reversed.value != head.value) return false;
            reversed = reversed.next;
            head = head.next;
        }
        return true;
    }

    static boolean recursion(LinkedList end) {
        if (end == null) return true;
        if (!recursion(end.next)) {
            return false;
        }
        if (startLi.value != end.value) return false;
        startLi = startLi.next;
        return true;
    }

    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList(3);
        linkedListOne.next = new LinkedList(1);
        linkedListOne.next.next = new LinkedList(7);
        linkedListOne.next.next.next = new LinkedList(1);
        linkedListOne.next.next.next.next = new LinkedList(3);
//        linkedListOne.next.next.next.next = new LinkedList(1);
//        linkedListOne.next.next.next.next.next = new LinkedList(0);
        System.out.println(linkedListPalindromeImplDifferent(linkedListOne));
    }
}
