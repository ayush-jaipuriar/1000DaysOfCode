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
      // If the kth node is the head, we set the head to its next node and then skip two nodes (head and next)
      first.value = first.next.value;
      first.next = first.next.next;
      return;
    }

    // Move both pointers until the second pointer reaches the end of the list
    while (second.next!= null) {
      count++;
      first = first.next;
      second = second.next;
    }
    // At this point, the second pointer is at the last node, and the first pointer is at the (k-1)th node from the end
    // We need to remove the kth node from the end, so we skip over it by setting the next of the first pointer to the node after the kth node
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