class RemoveDuplicatesFromLinkedList {
	// This is an input class. Do not edit.
	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	
	// Time Complexity : O(n). Note : Wont be O(n2) like it looks because we traverse the linked list only once. No node gets traversed more than once.
	// Space Complexity : O(1). 
	// n being the number of nodes in the linked list
	
	public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
		LinkedList currentNode = linkedList;
		while (currentNode != null) {
			LinkedList nextUniqueNode = currentNode.next;
			while (nextUniqueNode != null && nextUniqueNode.value == currentNode.value) {
				nextUniqueNode = nextUniqueNode.next;
			}
			currentNode.next = nextUniqueNode;
			currentNode = nextUniqueNode;
		}
		return currentNode;
	}
}