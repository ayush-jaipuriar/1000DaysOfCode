import java.util.*;

class Program {
  // Do not edit the class below except
  // for the breadthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    // Time Complexity : O(v+e)
    // Space Complexity : O(v) ; v = no of vertices and e = no of edges of the graph
    public List<String> breadthFirstSearch(List<String> array) {
      // Using a Queue data structure to store every node's children in order
      Queue<Node> queue = new LinkedList<>();
      // Adding the root node to the queue
      queue.add(this);
      // Looping through the queue and adding child nodes children in level order
      while (!queue.isEmpty()) {
        Node currentNode = queue.poll();
        array.add(currentNode.name);
        queue.addAll(currentNode.children);
      }
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
