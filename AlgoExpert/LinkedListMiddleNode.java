import java.util.*;

class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList middleNode(LinkedList linkedList) {
        // Initialize two pointers: slowPointer and fastPointer
        LinkedList slowPointer = linkedList;
        LinkedList fastPointer = linkedList;

        // Move fastPointer twice as fast as slowPointer
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // At this point, slowPointer points to the middle node
        return slowPointer;
    }
}
