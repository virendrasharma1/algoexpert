package linkedLists;

class reOrderList {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static ListNode reverseLinkedList(ListNode head) {
        ListNode main = head;
        ListNode prev = null;

        while (main != null) {
            ListNode nextNode = main.next;
            main.next = prev;
            prev = main;
            main = nextNode;
        }
        return prev;

    }

    static ListNode reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode main = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalf = reverseLinkedList(slow);
        while (head != null) {
            ListNode next = head.next;
            ListNode secondHalfNext = secondHalf != null ? secondHalf.next : null;
            head.next = secondHalf;
            if(head.next != null) head.next.next = next;
            secondHalf = secondHalfNext;
            head = next;
        }
        return main;
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
        node1.next.next.next.next = new ListNode(5);
//        node1.next.next.next.next.next = new ListNode(6);
//        node1.next.next.next.next.next.next = new ListNode(7);
//        node1.next.next.next.next.next.next.next = new ListNode(8);
//        node1.next.next.next.next.next.next.next.next = new ListNode(9);


        printLinkedList(reorderList(node1));
    }
}