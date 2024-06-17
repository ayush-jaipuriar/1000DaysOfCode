import java.util.*;

class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value; // Node value
        public LinkedList next; // Reference to the next node

        public LinkedList(int value) {
            this.value = value; // Initialize node with a value
            this.next = null; // Next node is initially null
        }
    }

    // Method to find the middle node of a linked list
    public LinkedList middleNode(LinkedList linkedList) {
        // Initialize two pointers: slowPointer and fastPointer at the head of the list
        LinkedList slowPointer = linkedList; // Moves one step at a time
        LinkedList fastPointer = linkedList; // Moves two steps at a time

        // Loop until fastPointer reaches the end of the list
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // Move slowPointer one step
            fastPointer = fastPointer.next.next; // Move fastPointer two steps
        }

        // At this point, slowPointer points to the middle node of the list
        return slowPointer;
    }
}