import java.util.*;
public class NodeDepth {
    // TC: O(n), SC: O(h) where n = num of nodes and h = height of the binary tree
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree (int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static int nodeDepth(BinaryTree root) {
        int depth = calculateNodeDepth(root, 0);
        return depth;
    }

    public static int calculateNodeDepth(BinaryTree root, int runningDepthSum) {
        if (root == null) {
            return 0;
        }
        return runningDepthSum + calculateNodeDepth(root.left, runningDepthSum + 1) + calculateNodeDepth(root.right, runningDepthSum + 1);
    }
    
}
