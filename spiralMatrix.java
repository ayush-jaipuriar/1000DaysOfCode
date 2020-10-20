class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length==0) {
            return list;
        }
        int startRow=0;
        int endRow=matrix.length-1;
        int startColumn=0;
        int endColumn=matrix[0].length-1;
        int count=0;
        int maxCount=matrix.length*matrix[0].length;
        while (startRow<=endRow && startColumn<=endColumn) {
            //print top row
            for (int i=startColumn; i<=endColumn; i++) {
                list.add(matrix[startRow][i]);
                count++;
            }
            startRow++;
            if (count==maxCount) {
                return list;
            }
            //print right column
            for (int i=startRow; i<=endRow; i++) {
                list.add(matrix[i][endColumn]);
                count++;
            }
            endColumn--;
            if (count==maxCount) {
                return list;
            }
            //print bottom row
            for (int i=endColumn; i>=startColumn; i--) {
                list.add(matrix[endRow][i]);
                count++;
            }
            endRow--;
            if (count==maxCount) {
                return list;
            }
            //print left column
            for (int i=endRow; i>=startRow; i--) {
                list.add(matrix[i][startColumn]);
                count++;
            }
            startColumn++;
            if (count==maxCount) {
                return list;
            }                        
        }
        return list;
        
        
    }
}
