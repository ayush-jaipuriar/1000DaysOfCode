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
}