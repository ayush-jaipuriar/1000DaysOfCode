import java.util.*;

class Program {
  // Time Complexity : O(N) 
  // Space Complexity : O(N) where N is the total number of elements in the array
  public static List<Integer> spiralTraverse(int[][] array) {
    if (array.length == 0) {
      return new ArrayList<Integer>();
    }

    // Initializing the parameter boundaries
    int rowStartIndex = 0;
    int rowEndIndex = array.length - 1;
    int colStartIndex = 0;
    int colEndIndex = array[0].length - 1;

    List<Integer> resultList = new ArrayList<>();

    while (rowStartIndex <= rowEndIndex && colStartIndex <= colEndIndex) {
      // Movement from top left to top right
      for (int col = colStartIndex; col<=colEndIndex; col++) {
        resultList.add(array[rowStartIndex][col]);
      }

      // Movement from top right to top bottom
      for (int row = rowStartIndex + 1; row<=rowEndIndex; row++) {
        resultList.add(array[row][colEndIndex]);
      }

      // Movement from bottom right to bottom left
      for (int col = colEndIndex - 1; col >= colStartIndex; col--) {
        // Edge case where there is only 1 row in the matrix
        if (rowStartIndex == rowEndIndex) {
          break;
        }
        resultList.add(array[rowEndIndex][col]);
      }

      // Movement from bottom left to bottom top
      for (int row = rowEndIndex - 1; row > rowStartIndex; row--) {
        // Edge case where the matrix has only 1 column
        if (colStartIndex == colEndIndex) {
          break;
        }
        resultList.add(array[row][colStartIndex]);        
      }

      // Moving the rows and columns inwards
      rowStartIndex++;
      rowEndIndex--;
      colStartIndex++;
      colEndIndex--;
    }
    return resultList;
  }
}
