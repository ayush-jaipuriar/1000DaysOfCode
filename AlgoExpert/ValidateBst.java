import java.util.*;

class Program {
  // Time Complexity : O(N); n is the number of nodes present in the tree
  // Space Complexity : O(d); d is the depth or height of the tree
  public static boolean validateBst(BST tree) {
    // we will keep track of minimum and maximum possible value any node in the binary tree can have
    // initially we will initialize the root node to have +infinity as its max value and -infinity as its min value
    int maxValue = Integer.MAX_VALUE;
    int minValue = Integer.MIN_VALUE;

    // Now we make a call to the helper method to determine if all the nodes satisfied the BST property or not
    return validateBstHelper(tree, minValue, maxValue); 
  }

  public static boolean validateBstHelper(BST tree, int minValue, int maxValue) {
    // Base Case : When we reach the null node i.e child of a leaf node, it will automatically be a valid bst
    if (tree == null) {
      return true;
    }
    // Recursive case: Checking if left node and right node both are valid
    // Left node is valid BST if its value is strictly less than its parent node value
    if (tree.value < maxValue && tree.value >= minValue) {
      boolean isLeftNodeValid = validateBstHelper(tree.left, minValue, tree.value);
      boolean isRightNodeValid = validateBstHelper(tree.right, tree.value, maxValue);
      return isLeftNodeValid && isRightNodeValid;      
    } else {
      return false;
    }
    
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
