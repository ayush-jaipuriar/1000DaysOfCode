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

    // Method to merge two sorted linked lists such that the merged list is also sorted.
    // Time Complexity : O(N + M); N is length of linked list 1 and M is the length of Linked List 2
    // Space Complexity : O(1)
    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Count the number of nodes in the first linked list
        int linkedListOneCount = 0;
        LinkedList listOnePointer = linkedListOne;

        while (listOnePointer!= null) {
            linkedListOneCount++;
            listOnePointer = listOnePointer.next;
        }

        // Count the number of nodes in the second linked list
        int linkedListTwoCount = 0;
        LinkedList listTwoPointer = linkedListTwo;

        while (listTwoPointer!= null) {
            linkedListTwoCount++;
            listTwoPointer = listTwoPointer.next;
        }

        // Calculate the difference in counts between the two lists
        int countDifference = Math.abs(linkedListOneCount - linkedListTwoCount);

        // Determine which list is shorter and which is longer
        LinkedList smallerList = (linkedListOneCount > linkedListTwoCount)? linkedListTwo : linkedListOne;
        LinkedList biggerList = (linkedListOneCount > linkedListTwoCount)? linkedListOne : linkedListTwo;

        // Adjust the pointer of the bigger list to point to the node after the smallest element
        for (int i = 0; i < countDifference; i++) {
            biggerList = biggerList.next;
        }

        // Merge the two lists by advancing both pointers until they meet
        while (biggerList!= smallerList) {
            biggerList = biggerList.next;
            smallerList = smallerList.next;
        }

        // Return the head of the merged list
        return biggerList;
    }
}