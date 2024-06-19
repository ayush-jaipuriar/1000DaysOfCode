import java.io.*;
import java.util.*;

class FindClosestValueInBSTRecursive {
    static Integer closest = Integer.MAX_VALUE;

    static class BST {
        int value;
        BST left;
        BST right;

        BST(int value) {
            this.value = value;
        }
    }

    // Method to find the closest value in a Binary Search Tree (BST)
    static int findClosestValueInBst(BST tree, int target) {

        // Average time complexity: O(log n), average space complexity: O(log n)
        // Worst-case time complexity: O(n) for a completely left or right-skewed BST,
        // Worst-case space complexity: O(n)
        if (tree == null) {
            // If the tree is null, return the current closest value found so far
            return closest;
        }
        // Check if the absolute difference between the target and the current node's
        // value
        // is less than the absolute difference between the target and the closest value
        // found so far
        if (Math.abs(tree.value - target) < Math.abs(closest - target)) {
            // Update the closest value if the condition above is true
            closest = tree.value;
        }

        // Recursive calls based on whether the target is less than or greater than the
        // current node's value
        if (target < tree.value) {
            return findClosestValueInBst(tree.left, target);
        } else if (target > tree.value) {
            return findClosestValueInBst(tree.right, target);
        } else {
            // Return the closest value if the target matches the current node's value
            // exactly
            return closest;
        }
    }

    // This is the more space efficient than recursive method ( O(1) over O(n) in
    // worst case), TC remains same as recursive
    static int findClosestValueInBstIterative(BST tree, int target) {
        BST currentNode = tree;
        // Worst Case : TC = O(n) for entirely left/right skewed tree and O(1) space
        // since we are not creating any new stack frames
        // Avg Case : TC = O(log n) and O(1) space
        while (currentNode != null) {
            if (Math.abs(target - currentNode.value) < Math.abs(target - closest)) {
                closest = currentNode.value;
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closest;
    }

}