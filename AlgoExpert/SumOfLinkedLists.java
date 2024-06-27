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

// Time Complexity : O(max(m,n)) time
// Space Complexity : O(max(m,n)) space; where m is the length of linkedListOne and n is the length of linkedListTwo
public LinkedList sumOfLinkedLists(
  LinkedList linkedListOne, LinkedList linkedListTwo
) {
  // Initialize a dummy linked list with a head node of value 0.
  // This dummy list will serve as a placeholder for the head of the resulting summed list.
  LinkedList dummyLinkedList = new LinkedList(0);
  
  // Set currentNode to point to the dummyLinkedList's head.
  // This allows us to easily append nodes to the beginning of the summed list.
  LinkedList currentNode = dummyLinkedList;

  // Initialize carry to 0. This variable will hold any overflow from addition operations.
  int carry = 0;

  // Initialize pointers to the heads of both input lists.
  LinkedList pointerOne = linkedListOne;
  LinkedList pointerTwo = linkedListTwo;

  // Iterate through both lists simultaneously, handling carry-over between digits.
  while (pointerOne!= null || pointerTwo!= null || carry > 0) {
    // Determine the values to add based on the current positions in each list.
    int valueOne = (pointerOne!= null)? pointerOne.value : 0;
    int valueTwo = (pointerTwo!= null)? pointerTwo.value : 0;

    // Calculate the current digit value and update the carry for the next iteration.
    int currentValue = (valueOne + valueTwo + carry) % 10;
    carry = (valueOne + valueTwo + carry) / 10;

    // Create a new node with the calculated value and append it to the summed list.
    LinkedList newNode = new LinkedList(currentValue);
    currentNode.next = newNode;
    currentNode = newNode;

    // Move to the next position in each list.
    pointerOne = (pointerOne!= null)? pointerOne.next : null;
    pointerTwo = (pointerTwo!= null)? pointerTwo.next : null;
  }

  // Return the head of the dummyLinkedList, effectively skipping over the initial 0 we added.
  return dummyLinkedList.next;
}
}
