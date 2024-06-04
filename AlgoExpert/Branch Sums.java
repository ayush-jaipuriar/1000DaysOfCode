import java.util.*;

class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        // Constructor for creating a new binary tree node with the given value
        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Calculates the sum of all branches in a binary tree and returns them as a list of integers.
     *
     * @param root The root node of the binary tree.
     * @return A list of sums of all branches in the binary tree.
     */
    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> resultList = new ArrayList<>();
        resultList = calculateSums(root, 0, resultList);
        return resultList;
    }

    /**
     * Recursively calculates the sum of all branches starting from the given root node.
     *
     * @param root The current node in the binary tree.
     * @param runningSum The current sum being calculated.
     * @param resultList The list to store the final sums.
     * @return The updated list of sums after processing the current node.
     */
    public static List<Integer> calculateSums(BinaryTree root, int runningSum, List<Integer> resultList) {
        // Base Case : When the root is null, we've reached a leaf node or an empty subtree.
        if (root == null) {
            return resultList;
        }

        // Base Case : When its a leaf node, add the current sum to the result list.
        if (root.left == null && root.right == null) {
            runningSum += root.value;
            resultList.add(runningSum);
        } else {
            // Recursive Case : If the node has children, recursively call calculateSums for both left and right subtrees,
            // adding the current node's value to the running sum before passing it along.
            resultList = calculateSums(root.left, runningSum + root.value, resultList);
            resultList = calculateSums(root.right, runningSum + root.value, resultList);
        }

        return resultList;
    }
}