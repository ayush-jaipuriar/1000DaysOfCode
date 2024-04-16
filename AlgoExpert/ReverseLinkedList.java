import java.util.*;

class Program {
    // Time Complexity : O(n)
    // Space Complexity : O(1); n is the number of nodes in linked list
    public static LinkedList reverseLinkedList(LinkedList head) {
        // We will have 3 pointers , p1 p2 and p3
        // p1 will initially point to null, p2 will point to head of linked list
        // p3 will point to p3 inside while loop

        LinkedList p1 = null;
        LinkedList p2 = head;

        while (p2 != null) {
            LinkedList p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        return p1;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
