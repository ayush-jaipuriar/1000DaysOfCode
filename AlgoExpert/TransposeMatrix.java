import java.util.*;

class Program {
    public int[][] transposeMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        // Create a new matrix to store the transposed result
        int[][] resultMatrix = new int[columnCount][rowCount];

        // Transpose the original matrix
        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                // Swap rows and columns to create the transposed element
                resultMatrix[i][j] = matrix[j][i];
            }
        }

        return resultMatrix;
    }
    // Time Complexity: O(N*M), where N is the number of rows and M is the number of columns.
    // We visit each element once during the transpose operation.
    
    // Space Complexity: O(N*M) for the resultMatrix, as we create a new matrix of the same size.
    // The input matrix is not modified in-place.
}
