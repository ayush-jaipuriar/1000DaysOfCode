package com.striver.sdesheet;

import java.util.Arrays;

public class SetMatrixZero {

	public static void main(String[] args) {

	}
	
	
	// Better but not the best approach
	// Uses two seperate arrays to keep track of rows or columns containing zeroes
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] zeroRows = new boolean[m];
        boolean[] zeroColumns = new boolean[n];
        // Filling the zeroRows and zeroColumns array as false initially
        Arrays.fill(zeroRows, false);
        Arrays.fill(zeroColumns, false);
    
        for (int i=0; i<m; i++) {
            for (int j=0; j<n;j++) {
                // If the matrix[i][j]th element is 0 then we set its corresponding ith and jth index 
                // in zeroRows and zeroColumns array as true, which would mean that that particular
                // row or column has a zero
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroColumns[j] = true;
                }
            }
        }

        // Now that we have filled the zeroRows and zeroColumns array, we will now iterate through the matrix
        // again and if the ith or jth index of zeroRows/zeroColumns array is true, we will make that matrix[i][j]th 
        // element as 0

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (zeroRows[i] || zeroColumns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }        
    }

}
