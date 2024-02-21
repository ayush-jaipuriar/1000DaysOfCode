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

	// Time Complexity : O(n). Note : Wont be O(n2) like it looks because we
	// traverse the linked list only once. No node gets traversed more than once.
	// Space Complexity : O(1).
	// n being the number of nodes in the linked list

	public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
		LinkedList currentNode = linkedList;
		// Loooping through the entire linked list
		while (currentNode != null) {
			LinkedList nextNode = currentNode.next;
			// We loop through the linked list till we get our first non duplicate value
			while (nextNode != null && currentNode.value == nextNode.value) {
				nextNode = nextNode.next;
			}
			// We are currently at a non duplicate nodem
			// So we set the next node of currentNode as nextNode
			// And we now to progress the linkedin traversal,
			// we set the currentNode as nextNode
			currentNode.next = nextNode;
			currentNode = nextNode;
		}
		return linkedList;
	}
}