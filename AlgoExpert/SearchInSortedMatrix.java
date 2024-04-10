import java.util.*;

class Program {
  // Time Complexity : O(m + n); m is the number of rows and n is the number of columns in the matrix
  // Space Complexity : O(1)
  
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int columns = matrix[0].length;

    int row = 0;
    int column = columns -1;

    while (row < rows && column >= 0) {
      int currentNum = matrix[row][column];
      // Case : currentNum < target i.e all numbers left to currentNum are also < target
      // Hence elimination left row elements and moving element down 1 row
      if (currentNum < target) {
        row++;
      } else if (currentNum > target) {
        // Case : currentNum > target i.e all numbers bottom to currentNum are also > target
        // Hence eliminating all bottom column elements and moving column left by 1
        column--;
      } else {
        // Case : currentNum == target, we have found our target element and just need to return its coordinates in the given matrix
        return new int[] {row,column};
      }
    }
    return new int[] {-1, -1};
  }
}
