import java.util.*;

// Define the main class for performing depth-first searches
class DFS {
    // Inner class representing a node in the graph/tree
    static class Node {
        String name; // Name of the node
        List<Node> children = new ArrayList<>(); // Children of the node

        // Constructor for creating a new node with a given name
        Node(String name) {
            this.name = name;
        }

        // Method to add a child node to the current node
        Node addChild(String name) {
            Node child = new Node(name); // Create a new child node
            children.add(child); // Add the child to the current node's children
            return this; // Return the current node for method chaining
        }

        // Method to perform a depth-first search starting from the current node
        // It adds the node's name to the provided list and recursively does the same for all its children
        List<String> depthFirstSearch(List<String> array) {
            // Add the current node's name to the array
            array.add(this.name);

            // Iterate over each child of the current node
            for (int i = 0; i < children.size(); i++) {
                // Recursively perform depth-first search on the child node
                children.get(i).depthFirstSearch(array);
            }

            // Return the array containing the names of all visited nodes in the order they were visited
            return array;
        }
    }
}s