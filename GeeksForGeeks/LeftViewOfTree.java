package GeeksForGeeks;

import java.util.*;

/*Left View of Binary Tree 

Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3
*/

public class LeftViewOfTree {
	/* A Binary Tree node */
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class Tree {
		ArrayList<Integer> list = new ArrayList<>();

		// Function to return list containing elements of left view of binary tree.
		ArrayList<Integer> leftView(Node root) {
			ArrayList<Integer> result = new ArrayList<>();			
			getLeftView(root, result, 0);
			return result;
		}
		
		public void getLeftView(Node root, List<Integer> result, int level) {
			if (root == null) {
				return;
			}
			if (level == result.size()) {
				result.add(root.data);
			}
			getLeftView(root.left, result, level+1);
			getLeftView(root.right, result, level+1);
		}
	}

}
