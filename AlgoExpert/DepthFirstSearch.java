import java.util.*;
class DFS {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        Node (String name) {
            this.name = name;
        }

        Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

        // Performs a depth-first search starting from the current node,
        // adding the node's name to the provided list and recursively doing the same for all its children.
        List<String> depthFirstSearch(List<String> array) {
            // Add the current node's name to the array
            array.add(this.name);

            // Iterate over each child of the current node
            for (int i=0; i<children.size(); i++) {
                // Recursively perform depth-first search on the child node
                children.get(i).depthFirstSearch(array);
            }

            // Return the array containing the names of all visited nodes in the order they were visited
            return array;
        }
    }
}