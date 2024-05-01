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

    // Time Complexity : O(N + M); N is length of linked list 1 and M is the lenght
    // of Linked List 2
    // Space Complexity : O(1)
    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        int linkedListOneCount = 0;
        LinkedList listOnePointer = linkedListOne;

        while (listOnePointer != null) {
            linkedListOneCount++;
            listOnePointer = listOnePointer.next;
        }

        int linkedListTwoCount = 0;
        LinkedList listTwoPointer = linkedListTwo;

        while (listTwoPointer != null) {
            linkedListTwoCount++;
            listTwoPointer = listTwoPointer.next;
        }

        int countDifference = Math.abs(linkedListOneCount - linkedListTwoCount);

        LinkedList smallerList = (linkedListOneCount > linkedListTwoCount) ? linkedListTwo : linkedListOne;
        LinkedList biggerList = (linkedListOneCount > linkedListTwoCount) ? linkedListOne : linkedListTwo;

        for (int i = 0; i < countDifference; i++) {
            biggerList = biggerList.next;
        }

        while (biggerList != smallerList) {
            biggerList = biggerList.next;
            smallerList = smallerList.next;
        }

        return biggerList;
    }
}
