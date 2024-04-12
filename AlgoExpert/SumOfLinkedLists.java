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
  // Space Comeplexity : O(max(m,n)) space; where m is length of linkedListOne and n is the length of linkedListTwo
  public LinkedList sumOfLinkedLists(
    LinkedList linkedListOne, LinkedList linkedListTwo
  ) {
    // Create a dummy linked list for reference to the head node of our summed linked list
    LinkedList dummyLinkedList = new LinkedList(0);
    // Create a pointer to this dummyLinkedList
    LinkedList currentNode = dummyLinkedList;

    int carry = 0;
    LinkedList pointerOne = linkedListOne;
    LinkedList pointerTwo = linkedListTwo;

    while (pointerOne != null || pointerTwo != null || carry > 0) {
      int valueOne = (pointerOne != null) ? pointerOne.value : 0;
      int valueTwo = (pointerTwo != null) ? pointerTwo.value : 0;

      int currentValue = (valueOne + valueTwo + carry) % 10;
      carry = (valueOne + valueTwo + carry) / 10;

      LinkedList newNode = new LinkedList(currentValue);
      currentNode.next = newNode;
      currentNode = newNode;

      pointerOne = (pointerOne != null) ? pointerOne.next : null;
      pointerTwo = (pointerTwo != null) ? pointerTwo.next : null;
    } 
    return dummyLinkedList.next;
  }
}
