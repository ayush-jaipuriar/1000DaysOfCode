import java.util.*;

class Program {
    public static void invertBinaryTree(BinaryTree tree) {
        // Using a Queue to perform BFS and traverse the tree
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            BinaryTree currentNode = queue.poll();
            swapNodes(currentNode);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    // Time Complexity : O(n) ; n is the number of nodes in the tree
    // Space Complexity : O(h) ; where h is the height of the tree which is worst
    // case
    // On average case of balanced binary tree the height is O(log n)
    public static void invertBinaryTreeRecursive(BinaryTree tree) {
        invertBinaryTreeHelper(tree);
    }

    public static void invertBinaryTreeHelper(BinaryTree tree) {
        // Base Case
        if (tree == null) {
            return;
        }

        // Recursive Case
        swapNodes(tree);
        invertBinaryTreeHelper(tree.left);
        invertBinaryTreeHelper(tree.right);
    }

    public static void swapNodes(BinaryTree tree) {
        BinaryTree tempNode = tree.left;
        tree.left = tree.right;
        tree.right = tempNode;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
