import java.util.*;

class Program {
  // Calculate the sum of depths of all nodes in a binary tree
  public static int nodeDepths(BinaryTree root) {
    return nodeDepthHelper(root, 0);
  }

  // Helper function to recursively compute node depths
  public static int nodeDepthHelper(BinaryTree root, int runningSum) {
    // Base Case: If the current node is null, return 0
    if (root == null) {
      return 0;
    }

    // Running Case:
    // Add the running sum (depth) to the depths of left and right subtrees
    return runningSum + nodeDepthHelper(root.left, runningSum + 1) + nodeDepthHelper(root.right, runningSum + 1);    
  }

  // Definition of a binary tree node
  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
