import java.util.*;

class Program {
  // Time Complexity : O(wh) time 
  // Space Complexity : O(wh) space; h is the height of the matrix and w is the width of the matrix
  public int[][] removeIslands(int[][] matrix) {

    // Traversing through the matrix
    for (int i=0; i<matrix.length; i++) {
      for (int j=0;j<matrix[0].length;j++) {
        boolean rowIsBorder = i==0 || i == matrix.length - 1;
        boolean colIsBorder = j==0 || j == matrix[0].length - 1;
        boolean isBorder = rowIsBorder || colIsBorder;

        if (!isBorder) {
          continue;
        }

        if (matrix[i][j] != 1) {
          continue;
        }

        // Handle for all 1s encountered in the border of the matrix
        changeOnesConnectedToBorderToTwos(matrix, i, j);        
      }
    }

    // Looping back again through the above matrix and changing all 2s to 1s
    for (int i=0; i<matrix.length; i++) {
      for (int j=0; j<matrix[0].length; j++) {
        int element = matrix[i][j];
        if (element == 1) {
          // Found Island, setting it to 0
          matrix[i][j] = 0;
        } else if (element == 2) {
          // Found Non Island 1 connected to border 1, changing it back from 2 to 1
          matrix[i][j] = 1;
        }
      }
    }
    return matrix;
    
  }

  public void changeOnesConnectedToBorderToTwos(int[][] matrix, int startRow, int startCol) {
    Stack<int[]> stack = new Stack<>();
    stack.add(new int[] {startRow, startCol});

    while (!stack.isEmpty()) {
      int[] currentPosition = stack.pop();
      int currentRow = currentPosition[0];
      int currentCol = currentPosition[1];

      // Set this border encountered 1 to 2
      matrix[currentRow][currentCol] = 2;

      // Now we set all the 1s connected to it i.e it neighbours to 2 as well
      int[][] neighbours = getNeighbours(matrix, currentRow, currentCol);

      for (int[] neighbour : neighbours) {
        int row = neighbour[0];
        int col = neighbour[1];

        if (matrix[row][col] != 1) {
          continue;
        }
        // Adding this neighbour to our stack for further DFS traversal
        stack.push(neighbour);
      }            
    }
  }

  public static int[][] getNeighbours(int[][] matrix, int currentRow, int currentCol) {
    int numRows = matrix.length;
    int numCols = matrix[0].length;
    List<int[]> temp = new ArrayList<>();
  
    if (currentRow - 1 >= 0) {
      temp.add(new int[] {currentRow-1, currentCol}); // UP
    }
    if (currentRow + 1 < numRows) {
      temp.add(new int[] {currentRow+1, currentCol}); // DOWN
    }
    if (currentCol - 1>= 0) {
      temp.add(new int[] {currentRow, currentCol - 1}); // LEFT
    }
    if (currentCol + 1 < numCols) {
      temp.add(new int[] {currentRow, currentCol + 1}); // RIGHT
    }

    int[][] neighbours = new int[temp.size()][2];
    for (int i=0;i<temp.size(); i++) {
      neighbours[i] = temp.get(i);
    }
    return neighbours;
  }
}
