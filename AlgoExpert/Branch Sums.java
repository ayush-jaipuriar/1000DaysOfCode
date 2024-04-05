import java.util.*;

class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> resultList = new ArrayList<>();
        resultList = calculateSums(root, 0, resultList);
        return resultList;
    }

    public static List<Integer> calculateSums(BinaryTree root, int runningSum, List<Integer> resultList) {
        // Base Case : When the root is null
        if (root == null) {
            return resultList;
        }

        // Base Case : When its a leaf node
        if (root.left == null && root.right == null) {
            runningSum += root.value;
            resultList.add(runningSum);
        }

        // Recursive Case : When the root has either the left or right child node or both
        resultList = calculateSums(root.left, runningSum + root.value, resultList);
        resultList = calculateSums(root.right, runningSum + root.value, resultList);
        return resultList;
    }

}
