import java.util.*;

// Feel free to add new properties and methods to the class.
class Program {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        // Time Complexity : O(1)
        // Space Complexity : O(1); n= number of elements in linked list
        public void setHead(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);
        }

        // Time Complexity : O(1)
        // Space Complexity : O(1); n= number of elements in linked list
        public void setTail(Node node) {
            if (tail == null) {
                setHead(node);
            }
            insertAfter(tail, node);
        }

        // Time Complexity : O(1)
        // Space Complexity : O(1); n= number of elements in linked list
        public void insertBefore(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) {
                return;
            }
            remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            if (node.prev == null) {
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        // Time Complexity : O(1)
        // Space Complexity : O(1); n= number of elements in linked list
        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) {
                return;
            }
            remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;
            if (node.next == null) {
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
        }

        // Time Complexity : O(p)
        // Space Complexity : O(1); p = position
        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }
            Node currentNode = head;
            int currentPosition = 1;
            while (currentNode != null && currentPosition++ != position) {
                currentNode = currentNode.next;
            }
            if (currentNode != null) {
                insertBefore(currentNode, nodeToInsert);
            } else {
                setTail(nodeToInsert);
            }
        }

        // Time Complexity : O(n)
        // Space Complexity : O(1); n= number of elements in linked list
        public void removeNodesWithValue(int value) {
            Node currentNode = head;
            while (currentNode != null) {
                Node nodeToRemove = currentNode;
                currentNode = currentNode.next;
                if (nodeToRemove.value == value) {
                    remove(nodeToRemove);
                }
            }
        }

        // Time Complexity : O(1)
        // Space Complexity : O(1); n= number of elements in linked list
        public void remove(Node node) {
            if (node == head) {
                head = head.next;
            }
            if (node == tail) {
                tail = tail.prev;
            }
            removeNodeBindings(node);
        }

        // Time Complexity : O(1)
        // Space Complexity : O(1); n= number of elements in linked list
        public void removeNodeBindings(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = null;
        }

        // Time Complexity : O(n)
        // Space Complexity : O(1); n= number of elements in linked list
        public boolean containsNodeWithValue(int value) {
            Node currentNode = head;
            while (currentNode != null && currentNode.value != value) {
                currentNode = currentNode.next;
            }
            return currentNode != null;

        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
