import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int evaluateExpressionTree(BinaryTree tree) {
        // Base case: If the node value is a positive integer, it's an operand
        if (tree != null && tree.value > 0) {
            return tree.value;
        }

        // Since it's not a positive integer, it's an operator
        int operator = tree.value;

        // Recursively evaluate left and right subtrees
        int leftResult = evaluateExpressionTree(tree.left);
        int rightResult = evaluateExpressionTree(tree.right);

        // Perform the operation based on the operator value
        if (operator == -1) {
            // Addition case
            return leftResult + rightResult;
        } else if (operator == -2) {
            // Subtraction case
            return leftResult - rightResult;
        } else if (operator == -3) {
            // Division case
            return leftResult / rightResult;
        }

        // Multiplication case
        return leftResult * rightResult;
    }
    // Time Complexity: O(N) where N is the total number of nodes in the tree.
    // We visit each node once during the recursive traversal.

    // Space Complexity: O(N) in the worst case due to the call stack during
    // recursion.
    // The maximum depth of the call stack corresponds to the height of the
    // expression tree.
    // If the tree is balanced, the height is log(N); if skewed, it can be N.
}
