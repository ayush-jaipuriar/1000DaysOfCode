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

        List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (int i=0; i<children.size(); i++) {
                children.get(i).depthFirstSearch(array);
            }
            return array;
        }

    }
}