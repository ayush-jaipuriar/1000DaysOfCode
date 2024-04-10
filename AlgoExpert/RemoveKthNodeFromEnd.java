import java.util.*;

class Program {
  // Time Complexity : O(N)
  // Space Complexity : O(1); N being the number of nodes in the linked list
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // First pointer
    LinkedList first = head;
    // Second Pointer
    LinkedList second = head;

    int count = 0;

    // Traversing the 2nd pointer upto k nodes in the linked list
    while (count < k) {
      second = second.next;
      count++;
    }

    // Corner case where kth node from end is the first node or the head node of the linked list
    if (second == null && count==k) {
      first.value = first.next.value;
      first.next = first.next.next;
      return;
    }

    while (second.next != null) {
      count++;
      first = first.next;
      second = second.next;
    }
    // Reached k-1th element from the end, now removing it from the linked list chain
    first.next = first.next.next;       
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
