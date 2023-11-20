package linkedLists;

import java.util.HashMap;

public class cloneListsWithRandomPointer {
    static class ListNode {
        int data;
        ListNode next;
        ListNode random;

        ListNode(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    static ListNode cloneTheLinkedList(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<>();

        if (head == null) return null;

        ListNode temp = head;

        while (temp != null) {
            map.put(temp, new ListNode(temp.data));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            ListNode cloneNode = map.get(temp);
            cloneNode.next = map.get(temp.next);
            cloneNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }


    public static ListNode cloneRandomList(ListNode head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and insert it after its original node
        ListNode current = head;
        while (current != null) {
            ListNode clone = new ListNode(current.data);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        // Step 2: Set random pointers for the cloned nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and cloned lists
        ListNode original = head;
        ListNode clonedHead = head.next;
        ListNode cloned = clonedHead;

        while (original != null) {
            original.next = original.next.next;
            original = original.next;

            cloned.next = (cloned.next != null) ? cloned.next.next : null;
            cloned = cloned.next;
        }

        return clonedHead;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print("[" + current.data + ", Random: " +
                    (current.random != null ? current.random.data : "null") + "] -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.next = node2;
        node2.next = node3;

        head.random = node3;
        node2.random = head;
        node3.random = node2;

        // Clone the linked list
        ListNode clonedHead = cloneTheLinkedList(head);

        // Print the original and cloned linked lists for verification
        System.out.println("Original List:");
        printList(head);

        System.out.println("Cloned List:");
        printList(clonedHead);
    }
}
