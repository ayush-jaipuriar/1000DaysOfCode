import java.util.*;

// Main class containing methods for traversing a Binary Search Tree (BST)
class Program {

    // Method for performing an inorder traversal of the BST
    // Inorder traversal visits nodes in the order: left -> root -> right
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Base case: if the tree is empty, return the array
        if (tree == null) {
            return array;
        }
        // Recursively traverse the left subtree
        inOrderTraverse(tree.left, array);
        // Visit the node
        array.add(tree.value);
        // Recursively traverse the right subtree
        inOrderTraverse(tree.right, array);
        return array;
    }

    // Method for performing a preorder traversal of the BST
    // Preorder traversal visits nodes in the order: root -> left -> right
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Base case: if the tree is empty, return the array
        if (tree == null) {
            return array;
        }
        // Visit the node
        array.add(tree.value);
        // Recursively traverse the left subtree
        preOrderTraverse(tree.left, array);
        // Recursively traverse the right subtree
        preOrderTraverse(tree.right, array);
        return array;
    }

    // Method for performing a postorder traversal of the BST
    // Postorder traversal visits nodes in the order: left -> right -> root
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Base case: if the tree is empty, return the array
        if (tree == null) {
            return array;
        }
        // Recursively traverse the left subtree
        postOrderTraverse(tree.left, array);
        // Recursively traverse the right subtree
        postOrderTraverse(tree.right, array);
        // Visit the node
        array.add(tree.value);
        return array;
    }

    // Inner class representing a node in the BST
    static class BST {
        // Value stored in the node
        public int value;

        // Reference to the left child node
        public BST left;

        // Reference to the right child node
        public BST right;

        // Constructor for creating a new node with the specified value
        public BST(int value) {
            this.value = value;
            // Initialize left and right children to null
            this.left = null;
            this.right = null;
        }
    }
}