public class CodingTest {
    public static void main(String[] args) {
        // [[
        // 0,0,0,1,1
        // 0,1,0,0,1
        // 0,0,0,0,0
        // ]]

        // {{0,0,0,1},
        //  {0,1,1,0},
        //  {1,0,0,1}}

        int[][] input = new int[][] 
            {   { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 1, 0, 0, 0 } };

                int numOfIslands = calculateNumberOfIslands(input);
                System.out.println(numOfIslands);

    }
    // 1 0 0
    // 0 1 0 matrix[i][j]
    // 0 0 0

    public static int calculateNumberOfIslands(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows < 3 || columns < 3) {
            return 0;
        }

        int islandCount = 0;

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                int currentElement = matrix[i][j];
                if (currentElement == 1) {
                    islandCount += checkIfIsland(matrix, i, j);
                }
            }
        }

        return islandCount;
    }

    public static int checkIfIsland(int[][] matrix, int row, int column) {
        // 1 x 0 x 0
        // 0 0 0 0 0matrix[i][j] row= 1, column=2
        // 0 0 1 0 0
        // 0 0 0 0 0

        // matrix[row-1][column-1] matrix[row-1] [col+1]
        // matrix [row+1][column-1] to matrix[row+1] [col+1]

        int islandCount = 0;
        int initialColumnIndex = column - 1;
        int initialRowIndex = row - 1;
        int currentElement = -1;
        // 1st loop: row on top
        while (initialColumnIndex <= column + 1) {
            currentElement = matrix[initialRowIndex][initialColumnIndex];
            if (currentElement != 0) {
                return 0;
            }
            initialColumnIndex++;
        }
        // Middle row
        // matrix[row][column-1] matrix[row][column+1]
        if (matrix[row][column - 1] != 0 && matrix[row][column + 1] != 0) {
            return 0;
        }

        //
        initialColumnIndex = column - 1;
        initialRowIndex = row + 1;
        while (initialColumnIndex <= column + 1) {
            currentElement = matrix[initialRowIndex][initialColumnIndex];
            if (currentElement != 0) {
                return 0;
            }
            initialColumnIndex++;
        }
        return 1;
    }

}
