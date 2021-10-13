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

    static int findClosestValueInBst(BST tree, int target) {

        // Time Complexity AVG: O(log n), Space Complexity AVG: O(log n) space
        // Time Complexity WORST : O(n) when bst is completely left or right skewed,
        // Space Complexity WORST: O(n)
        if (tree == null) {
            return closest;
        }
        if (Math.abs(tree.value - target) < Math.abs(closest - target)) {
            closest = tree.value;
        }

        if (target < tree.value) {
            return findClosestValueInBst(tree.left, target);
        } else if (target > tree.value) {
            return findClosestValueInBst(tree.right, target);
        } else {
            return closest;
        }
    }

    // This is the more space efficient than recursive method ( O(1) over O(n) in worst case), TC remains same as recursive
    static int findClosestValueInBstIterative(BST tree, int target) {
        BST currentNode = tree;
        // Worst Case : TC = O(n) for entirely left/right skewed tree and O(1) space since we are not creating any new stack frames
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